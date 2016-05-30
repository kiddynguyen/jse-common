package com.minhtu.core.io.network.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private static final int MAX_REQUESTS = 1;
    private static final int PORT_NUMBER = 9999;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        
        Socket clientSocket = null;
        BufferedReader bufferReader = null;
        BufferedWriter bufferWriter = null;

        // Try to open a server socket on port 9999
        // Note that we can't choose a port less than 1023 if we are not
        // privileged users (root)
        try {
            serverSocket = new ServerSocket(PORT_NUMBER, MAX_REQUESTS);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            // Wait for new connection from client
            while (true) {
                clientSocket = serverSocket.accept();
                InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
                bufferReader = new BufferedReader(reader);
                
                OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
                bufferWriter = new BufferedWriter(writer);
                
                String clientAddress = clientSocket.getInetAddress().getHostName();
                int clientPort = clientSocket.getPort();
                
                // Poll message from client
                String msgFromClient = null;
                while ((msgFromClient = bufferReader.readLine()) != null) {
                    System.out.println(msgFromClient);
                    
                    String msgToClient = "From " + clientAddress + ":" + clientPort + ": " + msgFromClient;
                    bufferWriter.write(msgToClient);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                bufferReader.close();
                bufferWriter.close();
            } catch (IOException ioe) {}
        }
    }
}
