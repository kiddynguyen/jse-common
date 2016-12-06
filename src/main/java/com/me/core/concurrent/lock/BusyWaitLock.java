package com.me.core.concurrent.lock;

/**
 * A lock implementation using volatile variable and infinite loop.
 * This approach is not good for CPU utilization due to the waiting thread is active
 * 
 * @author tunm2
 */
public class BusyWaitLock {
    
    private volatile boolean locked = false;

    public void lock() {
        while (locked) {
        }
        locked = true;
    }

    public void unlock() {
        locked = false;
    }
    
    public static void main(String[] args) throws InterruptedException {
        final BusyWaitLock lock = new BusyWaitLock();
        
        // thread 1 try lock and unlock after 5 seconds
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {}
                
                lock.unlock();
            }
        }, "Thread1");
        thread1.start();
        
        // thread 2 try lock
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " waked up");
            }
        }, "Thread2");
        thread2.start();
    }
}