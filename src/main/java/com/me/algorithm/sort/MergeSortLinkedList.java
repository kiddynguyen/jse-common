package com.me.algorithm.sort;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author tunm2
 */
public class MergeSortLinkedList {
    
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            int num = rand.nextInt(1000000);
            list.add(num);
        }
        
        System.out.println("before:\t" + list);
        List<Integer> list2 = mergesort(list);
        System.out.println("after:\t" + list2);
        
        System.exit(0);
    }
    
    static List<Integer> mergesort(List<Integer> list) {
        int size = list.size();
        if (size == 1)
            return list;
        
        int mid = size/2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, size);
        
        left = mergesort(left);
        right = mergesort(right);
        return merge(left, right);
    }
    
    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int size1 = list1.size(), size2 = list2.size();
        int size = size1 + size2;
        List<Integer> list = new ArrayList(size);
        
        // list1.last <= list2.first
        if (list1.get(size1-1) <= list2.get(0)) {
            list.addAll(list1);
            list.addAll(list2);
            return list;
        }
        
        // list2.last <= list1.first
        if (list2.get(size2-1) <= list1.get(0)) {
            list.addAll(list2);
            list.addAll(list1);
            return list;
        }
        
        int i1 = 0, i2 = 0;
        while (i1 < size1 && i2 < size2) {
            int el1 = list1.get(i1), el2 = list2.get(i2);
            if (el1 < el2) {
                list.add(el1);
                i1++;
            } else {
                list.add(el2);
                i2++;
            }
        }
        
        if (i1 == size1) {
            list.addAll(list2.subList(i2, size2));
        } else if (i2 == size2) {
            list.addAll(list1.subList(i1, size1));
        }
        
        return list;
    }
}
