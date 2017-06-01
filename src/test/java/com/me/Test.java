package com.me;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author tunm2
 */
public class Test extends LinkedHashMap<Object, Object> {
    
    private int lruSize;
    
    public Test(int initialCapacity) {
        super(initialCapacity, 0.75F, true);
        this.lruSize = (int)(initialCapacity * 0.75F);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
        return size() > lruSize;
    }
    
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
    }
    
}
