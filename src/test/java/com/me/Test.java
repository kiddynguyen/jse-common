package com.me;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tunm2
 */
public class Test {
    
    	private static AtomicInteger count =  new AtomicInteger(0);
    public static void main(String[] args) {
        count.incrementAndGet();
        try {
            String s = "";
        } catch (Exception e) {
            throw e;
        }
    }
}
