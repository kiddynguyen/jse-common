package com.minhtu.core.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface
 * 
 * @author nminhtu
 */
public interface Adder extends Remote {
    public int add(int x, int y) throws RemoteException;
}
