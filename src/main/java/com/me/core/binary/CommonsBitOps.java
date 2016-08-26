package com.me.core.binary;

/**
 * @author tunm2
 */
public class CommonsBitOps {
    public static void main(String[] args) {
        int hi = 0x12345678; //
        int bi = 0b00010010001101000101011001111000;
        System.out.println("hi = " + hi);
        System.out.println("bi = " + bi);
        
        System.out.println("hi = " + Integer.toBinaryString(hi));
        System.out.println("bi = " + Integer.toHexString(bi));
    }
    
    
}
