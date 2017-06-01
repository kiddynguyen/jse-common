package com.me;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tunm2
 */
public class TestConc {
    
    static Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        lock.lock();
        lock.lock();
        lock.unlock();
    }
}
