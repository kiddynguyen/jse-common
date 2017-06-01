package com.me.core.concurrent.lock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tunm2
 */
public class SynchronizedBlocks {
    
    public static void main(String[] args) throws Exception {
        final SynchronizedBlocks inst1 = new SynchronizedBlocks();
        final SynchronizedBlocks inst2 = new SynchronizedBlocks();
    
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedBlocks.synchronizeStaticMethod();
                    inst1.synchronizeInstanceMethod();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SynchronizedBlocks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedBlocks.synchronizeStaticMethod();
                    inst2.synchronizeInstanceMethod();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SynchronizedBlocks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread2.start();
    }
    
    private synchronized void synchronizeInstanceMethod() throws InterruptedException {
        System.out.println("Start synchronizeInstanceMethod");
        Thread.sleep(5000);
        System.out.println("Finish synchronizeInstanceMethod");
    }
    
    private synchronized static void synchronizeStaticMethod() throws InterruptedException {
        System.out.println("Start synchronizeStaticMethod");
        Thread.sleep(5000);
        System.out.println("Finish synchronizeStaticMethod");
    }
    
}
