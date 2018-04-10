package com.me.core.concurrent.sync;

/**
 *
 * @author tunm2
 */
public class Lock {
    
    volatile boolean locked = false;
    
    void lock() {
        while (locked) {
        }
        locked = true;
    }
    
    void unlock() {
        locked = false;
    }
    
}
