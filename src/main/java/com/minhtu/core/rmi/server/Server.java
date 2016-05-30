package com.minhtu.core.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import static com.minhtu.core.rmi.RmiConstants.*;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(RMI_PORT);
            System.out.println("java RMI registry already exists.");
            
            Adder stub = new AdderImpl();
            Naming.rebind(RMI_NAME, stub);
            System.out.println("RMI Server bound to registry");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
