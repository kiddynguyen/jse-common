package com.me.core.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tunm2
 */
public class Collections {
    
    ///////////////////////////////////////////
    //  LIST
    ///////////////////////////////////////////
    // max size = Integer.MAX_VALUE, because java array max size is Integer.MAX_VALUE
    static List<Object> arrayList = new ArrayList<>();
    static List<Object> vector = new Vector<>();
    static List<Object> stack = new Stack<>();
    static List<Object> threadSafeList = new CopyOnWriteArrayList<>();
    // no limit size
    static List<Object> linkedList = new LinkedList<>();
    
    ///////////////////////////////////////////
    //  MAP
    ///////////////////////////////////////////
    static Map<Object, Object> hashMap = new HashMap<>();
    static Map<Object, Object> linkedHashMap = new LinkedHashMap<>();
    static Map<Object, Object> treeMap = new TreeMap<>();
    
    static Map<Object, Object> hashTable = new Hashtable<>();
    static Map<Object, Object> concurrentMap = new ConcurrentHashMap<>();
 
    ////////////////////////////////////////////
    //  QUEUE
    ////////////////////////////////////////////
    static Queue<Object> queue = new ArrayDeque<>();
    // size of blocking queue is fixed, not able resizable
    // linkedqueue: if not pass initial size then default capacity = Integer.MAX_VALUE
    static BlockingQueue<Object> linkedQueue = new LinkedBlockingQueue<>();
    // must pass initial size, max is Integer.MAX_SIZE
    static BlockingQueue<Object> arrayQueue = new ArrayBlockingQueue<>(10);
    static DelayQueue delayQueue = new DelayQueue();
    
    
    public static void main(String[] args) throws InterruptedException {
        
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = 2 * corePoolSize;
        BlockingQueue taskQueue = new LinkedBlockingQueue<>(8);
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0, TimeUnit.MILLISECONDS, taskQueue);
        
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task(i, 10));
        }
        
        while (true) {
            int activedThreads = executor.getActiveCount();
            int largestPoolSize = executor.getLargestPoolSize();

            System.err.println("++ activedTheads: " + activedThreads);
            System.err.println("++ largestPoolS: " + largestPoolSize);
            
            Thread.sleep(1000);
        }
    }
    
    static class Task implements Runnable {
        int id;
        int size;
        
        public Task(int id, int size) {
            this.id = id;
            this.size = size;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * size);
                System.err.println(id + " done!");
            } catch (InterruptedException e) {}
        }
    }
}