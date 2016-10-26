package com.me.core.binary;

/**
 * @author tunm2
 */
public class CommonsBitOps {
    
    static int VALUE = 0x1234; // 0b0001001000110100
    
    public static void main(String[] args) {
        System.out.println("ORIGINAL: " + Integer.toBinaryString(VALUE));
        
        int reversed = reverseBits(VALUE);
        System.out.println("REVERSED: " + Integer.toBinaryString(reversed));
        
        int lastKBits = getLastKBits(VALUE, (byte)8);
        System.out.println("LAST 10 BITs: " + Integer.toBinaryString(lastKBits));
    }
    
    // dao nguoc cac bits cua 1 so i32
    static int reverseBits(int value) {
        return value ^ Integer.MAX_VALUE;
    }
    
    // lay k bits cuoi cung cua so i32
    static int getLastKBits(int value, byte k) {
        return (value << (32 - k)) >> (32 - k);
    }
    
    // lay k bits dau tien cua so i32
    static int getFirstKBits(int value, byte k) {
        return value >> (32 - k);
    }
}