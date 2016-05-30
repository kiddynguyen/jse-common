package com.minhtu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private static final int MAX_REQUESTS = 1;
    private static final int PORT_NUMBER = 9999;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(PORT_NUMBER, MAX_REQUESTS);
        } catch (IOException e) {
            System.out.println(e);
        }

        BufferedInputStream bufferInput = null;
        BufferedOutputStream bufferOutput = null;
        
        try {
            // Wait for new connection from client
            while (true) {
                Socket clientSocket = serverSocket.accept();
                bufferInput = new BufferedInputStream(clientSocket.getInputStream());
                bufferOutput = new BufferedOutputStream(clientSocket.getOutputStream());
                
                String clientAddress = clientSocket.getRemoteSocketAddress().toString();
                int clientPort = clientSocket.getPort();
                
                // read data from client
                byte[] data = new byte[1024];
                while (bufferInput.read(data) != -1) {
                    
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                bufferInput.close();
                bufferOutput.close();
            } catch (IOException ioe) {}
        }
    }
}
