/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattis
 * 
 * TODO:
 * Gör så den skickar meddelande och kan ta emot och skicka meddelande samtidigt, behöver kanske inte ha 
 * skicka meddelande som en egen tråd utan kan ha den som en funktion som man kallar när användaren har 
 * skrivit in ett meddelande och tryckt på enter.
 */
public class ChatClient {
    private Socket server;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private RecieveMessages recieveMessages;
    
    public ChatClient(String host, int portNr){
        try {
            server = new Socket(host, portNr);
            dataInputStream = new DataInputStream(server.getInputStream());
            dataOutputStream = new DataOutputStream(server.getOutputStream());
            recieveMessages = new RecieveMessages();
        } catch (UnknownHostException ex) {
            System.out.println("unknown host");
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("ioexception");
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ChatClient client = new ChatClient("127.0.0.1", 5784);
        client.runClient();
        
        String message = "";
        while(!(message.compareTo("!EXIT") == 0)){
            message = scanner.next();
            client.sendMessage(message);
        }
    }
    
    public void runClient(){
        (new Thread(recieveMessages)).start();
    }
    
    public class RecieveMessages implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    System.out.println(dataInputStream.readUTF());
                } catch (IOException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public class SendMessages implements Runnable{

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    
    public void sendMessage(String message){
        try {
            dataOutputStream.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
