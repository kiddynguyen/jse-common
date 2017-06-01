package com.me;

/**
 *
 * @author tunm2
 */
public class Test2 {
    
    final Object lock = new Object();
    
    public static void main(String[] args) throws Exception {
        new Test2().testNotify();
    }
    
    public void testNotify() throws Exception {
        // BACKGROUND THREADS
        Thread thread1 = new Thread(new BkgTask(7000L, "Thread 1", lock));
        Thread thread2 = new Thread(new BkgTask(4000L, "Thread 2", lock));
        thread1.start();
        thread2.start();
        
        // CURRENT THREAD
        synchronized (lock) {
            lock.wait();
            lock.wait();
        }
        
        System.out.println("All threads done!");
    }
    
    static class BkgTask implements Runnable {
        
        long time;
        String name;
        final Object lock;
        
        public BkgTask(long time, String name, Object lock) {
            this.time = time;
            this.name = name;
            this.lock = lock;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(time);
                System.out.println(name + " done");
                synchronized (lock) {
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
