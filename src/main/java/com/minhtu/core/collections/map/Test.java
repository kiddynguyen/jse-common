package com.minhtu.core.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tunm2
 */
public class Test {
    
    public static void main(String[] args) {
//        SortedMap<ObjectKey, String> map2 = new TreeMap();
//        for (int i = 10; i >= 0; i--) {
//            ObjectKey key = new ObjectKey(i, "i_" + i, true);
//            map2.put(key, "i_" + i);
//        }
//        
//        Map<Integer, String> map = new LinkedHashMap<>();
//        map.put(333, "333");
//        map.put(222, "222");
//        
//        for (Integer key : map.keySet()) {
//            String value = map.get(key);
//            System.out.println(value);
//        }
//        
//        System.out.println(map2);
        
        Map<Integer, Long> map = new HashMap<>();
        map.put(1, Long.MIN_VALUE);
        map.put(2, Long.MAX_VALUE);
        
        List<Long> values = new ArrayList<>(map.values());
        System.out.println(values);
    }
    
    static void testHashcodeAndEquals() {
        ObjectKey key1 = new ObjectKey(1, "tu", true);
        ObjectKey key2 = new ObjectKey(1, "tu", false);
        
        System.out.println("key1: " + key1.toString());
        System.out.println("key1.hashcode: " + key1.hashCode());
        System.out.println("key2: " + key2.toString());
        System.out.println("key2.hashcode: " + key2.hashCode());
        
        System.out.println("key1.equals(key2): " + key1.equals(key2));
        System.out.println(0xda);
        
        Map<ObjectKey, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        
        System.out.println(map);
    }
}

