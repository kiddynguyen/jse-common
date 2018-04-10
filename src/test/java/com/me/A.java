package com.me;

import java.util.Arrays;

class A {
    
    public static void main(String[] args) {
        int[] ints = { -9, 8, 2, -5, 7 };
int result = A.closestToZero(ints);

System.out.println(result);
    }
	
	/** @return the number that is closest to​​​​​​​‌​‌​​​‌‌‌‌​​‌‌‌‌‌​‌​‌​​‌ zero */
    static int closestToZero(int[] ints) {
        if (ints == null || ints.length == 0) {
            return 0;
        }
        
        Arrays.sort(ints);
        
        int left = 0, right = ints.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ints[mid] == 0) {
                return ints[mid+1];
            } else if (ints[mid] > 0) {
                if (ints[mid-1] <= 0) {
                    return ints[mid];
                } else {
                    right = mid-1;
                }
            } else {
                left = mid + 1;
            }
        }
        
        return 0;
	}
}