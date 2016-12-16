package com.me.core.collections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tunm2
 */
public class Collections {
    
    // max size = Integer.MAX_VALUE, because java array max size is Integer.MAX_VALUE
    static List<Integer> arrayList = new ArrayList<>();
    static List<Integer> threadSafeList = new CopyOnWriteArrayList<>();
    // no limit size
    static List<Integer> linkedList = new LinkedList<>();
    
    static Map<String, Object> map = new Hashtable<>();
    static Map<String, Object> map2 = new ConcurrentHashMap<>();
    static Map<String, Object> tmap = new TreeMap<>();
    
    // size of blocking queue is fixed, not able resizable
    // linkedqueue: if not pass initial size then default capacity = Integer.MAX_VALUE
    static BlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<>();
    // must pass initial size, max is Integer.MAX_SIZE
    static BlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<>(10);
    static DelayQueue delayQueue = new DelayQueue();
    
    public static void main(String[] args) {
        Timer timer = new Timer();
    }
}
