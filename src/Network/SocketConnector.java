/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattis
 */
public class SocketConnector {

    private Socket connectorSocket;
    private DataInputStream inStream;
    private DataOutputStream outputStream;

    public SocketConnector() {
        try {
            connectorSocket = new Socket("vortex.labs.overthewire.org", 5842);
            inStream = new DataInputStream(connectorSocket.getInputStream());
            outputStream = new DataOutputStream(connectorSocket.getOutputStream());
        } catch (UnknownHostException ex) {
            System.out.println("unknown host");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    public static void main(String[] args) {
        SocketConnector socketConnector = new SocketConnector();
        DataInputStream input = socketConnector.getInStream();
        DataOutputStream output = socketConnector.getOutputStream();
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            try {
                sum += input.readInt();
                System.out.println("" + sum);
            } catch (IOException ex) {
                System.out.println("couldn't read int");
            }
        }
        try {
            output.writeInt(sum);
        } catch (IOException ex) {
            System.out.println("couldn't write int");
        }

        System.out.println("done adding numbers recieving login: ");

        try {
            System.out.println(input.readUTF());
            // System.out.println(input.readUTF());
        } catch (IOException ex) {
            System.out.println("couldn't read string");
        }
        
        System.out.println("done");
    }

    public DataInputStream getInStream() {
        return inStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }
}
