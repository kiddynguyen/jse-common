package com.me.core.concurrent.signal;

/**
 * The mechanic behind Lock/Semaphore...
 * 
 * @author tunm2
 */
public class ThreadSignaling {

    /**
     * A thread signaling mechanic using volatile variable and infinite loop. 
     * This approach is not good for CPU utilization due to the waiting thread is active
     */
    class BusyWaitSignaling {
        private volatile boolean signalled = false;

        public void doWait() {
            while (!signalled) {
            }
        }

        public void doNotify() {
            signalled = true;
        }
    }
    
    /**
     * Two problems:
     *  1 Missed signal (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     *  2 Spurious wakeup (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     */
    class WaitNotifySignaling1 {
        public synchronized void doWait() throws InterruptedException {
            this.wait();
        }
        
        public synchronized void doNotify() {
            this.notify();
        }
    }
    
    /**
     * Fix issue missed signal
     * One problem:
     *   Spurious wakeup (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     */
    class WaitNotifySignaling2 {
        private boolean signalled = false;

        public synchronized void doWait() throws InterruptedException {
            if (!signalled) {
                wait();
            }
        }

        public synchronized void doNotify() {
            signalled = true;
            notify();
        }
    }
    
    /**
     * Overcome two issues above
     */
    class WaitNotifySignaling3 {
        private boolean signalled = false;

        public synchronized void doWait() throws InterruptedException {
            while (!signalled) {
                wait();
            }
        }

        public synchronized void doNotify() {
            signalled = true;
            notify();
        }
    }
}
