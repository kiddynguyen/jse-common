package com.me.core.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tunm2
 */
public class JavaReentrantLock {
    
    private static final ReentrantLock lock = new ReentrantLock();
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task());
            System.out.println(thread.getName() + ": queue length = " + lock.getQueueLength());
            thread.start();
        }
        
        Thread.sleep(5000);
        System.out.println("final queue length = " + lock.getQueueLength());
        lock.unlock();
    }
    
    static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock();
        }
    }
}
