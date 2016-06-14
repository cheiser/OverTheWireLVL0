/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattis
 */

/*
 * 
 * Skapa en klass som får innehålla all information så som sockets(alla anslutna) och alla hittills inkommna meddelanden
 * Skapa privata klasser som får implementera runnable som får ligga och köra hela tiden och den ena får ta emot meddelanden
 * och lägga till dem i klassen som håller data och den andra får skicka ut det mottagna till alla anslutna sockets
 * Får nog också ha en klass som bara ligger och lyssnar efter anslutningar och lägger till dem i kmi när dem ansluter
 * 
 * Kanske ha lock i klassen med information(kmi)
 * 
 * TODO:
 * Kan lägga till så den i metoden recieveinformation appendar ip'n från den som skickat meddelandet och
 * sedan i klienten inte skriva ut de meddelanden som kommer från en själv.... såvida jag inte gör den grafisk för då lär man
 * ju ha två olika fönster, ett för input och ett för output så då kan man ju skriva ut det igen i outputen och ta bort
 * det från inputen
 * 
 */
public class ChatServer {
    private ServerInformation serverInfo;
    private ListenForConnection lfc;
    private ForwardInformation fi;
    
    public ChatServer(){
        try {
            serverInfo = new ServerInformation();
            serverInfo.setConnectorSocket(new ServerSocket(5784));
            serverInfo.setClients(new ArrayList<Socket>());
            serverInfo.setMessages(new ArrayList<String>());
            lfc = new ChatServer.ListenForConnection();
            fi = new ChatServer.ForwardInformation();
            
        } catch (UnknownHostException ex) {
            System.out.println("unknown host");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
    
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer();
        chatServer.startServer();
    }
    
    public void startServer(){
        (new Thread(lfc)).start();
        (new Thread(fi)).start();
    }
    public class ListenForConnection implements Runnable{
        
        @Override
        public void run() {
            ServerSocket connectorSocket = serverInfo.getConnectorSocket();
            ArrayList<Socket> clients = serverInfo.getClients();
            while(true){
                Socket tempSocket = null;
                try {
                    tempSocket = connectorSocket.accept();
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                clients.add(tempSocket);
                (new Thread(new RecieveInformation(tempSocket))).start();
        }
        }
    }
    
    
    public class ForwardInformation implements Runnable{
        
        @Override
        public void run() {
            while(true){
                String message = serverInfo.getLatestMessage();
                forwardInformation(message, serverInfo.clients);
                // använd lock här och när det har kommit in något så skickar man det senaste i serverinfo.messages
            }
        }
        
        public void forwardInformation(String recievied, ArrayList<Socket> clients){
        for(Socket tempSocket: clients){
            try {
                DataOutputStream outStream = new DataOutputStream(tempSocket.getOutputStream());
                outStream.writeUTF(recievied);
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
    
    public class RecieveInformation implements Runnable{
        private Socket clientSocket;
        private DataInputStream dataInStream;
        
        public RecieveInformation(Socket client){
            clientSocket = client;
            try {
                this.dataInStream = new DataInputStream(clientSocket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
        public void run() {
            while(!clientSocket.isClosed()){
                try {
                    String temp = dataInStream.readUTF();
                    serverInfo.addMessage(temp);
                    // använd lock här och när det har kommit in något så skickar man det senaste i serverinfo.messages
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private class ServerInformation{
        private ServerSocket connectorSocket;
        private DataInputStream inStream;
        private DataOutputStream outputStream;
        private ArrayList<Socket> clients; //  = new ArrayList<Socket>();
        private ArrayList<String> messages; // = new ArrayList<String>();
        
        private Lock lock = new ReentrantLock();
        private Condition messageRecieved = lock.newCondition();

        public ArrayList<Socket> getClients() {
            return clients;
        }

        public ServerSocket getConnectorSocket() {
            return connectorSocket;
        }

        public DataInputStream getInStream() {
            return inStream;
        }

        public ArrayList<String> getMessages() {
            return messages;
        }

        public DataOutputStream getOutputStream() {
            return outputStream;
        }

        public void setClients(ArrayList<Socket> clients) {
            this.clients = clients;
        }

        public void setConnectorSocket(ServerSocket connectorSocket) {
            this.connectorSocket = connectorSocket;
        }

        public void setInStream(DataInputStream inStream) {
            this.inStream = inStream;
        }

        public void setMessages(ArrayList<String> messages) {
            this.messages = messages;
        }

        public void setOutputStream(DataOutputStream outputStream) {
            this.outputStream = outputStream;
        }
        
        
        public void addMessage(String message){
            lock.lock();
            try{
                messages.add(message);
                messageRecieved.signalAll();
            } finally{
                lock.unlock();
            }
        }
        
        public String getLatestMessage(){
            lock.lock();
            String message = "";
            try{
                messageRecieved.await();
                message = messages.get(messages.size()-1);
            } finally{
                lock.unlock();
                return message;
            }
        }
        
    }
}
