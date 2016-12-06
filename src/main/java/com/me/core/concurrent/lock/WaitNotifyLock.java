package com.me.core.concurrent.lock;

/**
 * An lock implementation using wait/notify mechanic of Object.
 * This approach is good for CPU utilization due to the waiting thread is inactive
 * 
 * @author tunm2
 */
public class WaitNotifyLock {
    
    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {
        if (locked)
            wait();
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
    
    public static void main(String[] args) throws InterruptedException {
        final WaitNotifyLock lock = new WaitNotifyLock();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println(Thread.currentThread().getName() + " waiting...");
                try {
                    lock.lock();
                } catch (InterruptedException ex) {}
                System.err.println(Thread.currentThread().getName() + " waked up");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                }
                lock.unlock();
            }
        }, "Thread1");
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println(Thread.currentThread().getName() + " waiting...");
                try {
                    lock.lock();
                } catch (InterruptedException ex) {}
                System.err.println(Thread.currentThread().getName() + " waked up");
            }
        }, "Thread2");
        thread2.start();
    }
}