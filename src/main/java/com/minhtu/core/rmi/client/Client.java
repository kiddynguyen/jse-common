package com.minhtu.core.rmi.client;

import static com.minhtu.core.rmi.RmiConstants.RMI_NAME;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.minhtu.core.rmi.server.Adder;

public class Client {
    public static void main(String[] args) {
        try {
            Adder stub = (Adder) Naming.lookup(RMI_NAME);
            int total = stub.add(5, 10);
            System.out.println(total);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}