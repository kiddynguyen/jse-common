package com.me;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple Application
 */
public class AppTest {
    
    public static void main(String[] args) throws IOException {
        int corePoolSize = 100;
        int maxPoolSize = 200;
        long keepAliveTime = 0;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, queue);
        
        ExecutorService executor2 = Executors.newFixedThreadPool(100);
    }
}

