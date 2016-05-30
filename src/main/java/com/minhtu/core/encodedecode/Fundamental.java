package com.minhtu.core.encodedecode;

/**
 *
 * @author tunm2
 */
public class Fundamental {
    
    public static void main(String[] args) {
        int ihex = 0x90;
        byte bhex = (byte) 0x90;
        int bihex = 0b10010000;
        
        System.out.println("ihex 0x90: " + ihex);
        System.out.println("bhex 0x90: " + bhex);
        System.out.println("bihex 0b10010000: " + bihex);
    }
    
}
