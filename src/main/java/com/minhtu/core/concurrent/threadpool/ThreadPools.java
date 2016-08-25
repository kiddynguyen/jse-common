package com.minhtu.core.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tunm2
 */
public class ThreadPools {
    
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
    static ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    
    static ExecutorService executor = Executors.newFixedThreadPool(10);    
    
    public static void main(String[] args) {
//        threadPool.
    }
}
