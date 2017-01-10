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
    
    
    ////////////////////////////////////////////
    // TESTING
    ////////////////////////////////////////////
    public static void main(String[] args) {
        int arr[] = new int[Integer.MAX_VALUE-5];
    }
}