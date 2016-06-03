package com.minhtu.core.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tunm2
 */
public class Collections {
    
    // max size = Integer.MAX_VALUE, because java array max size is Integer.MAX_VALUE
    static List<Integer> arrayList = new ArrayList<>();
    // no limit size
    static List<Integer> linkedList = new LinkedList<>();
    
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
