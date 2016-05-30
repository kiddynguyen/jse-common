package com.minhtu.core.memory;

/**
 * @author tunm2
 */
public class MemStorage {
    //--------------------------
    // HIGH BYTE --- LOW BYTE
    //--------------------------
    
    private static int i32h = 0x01020304; // 4 bytes
    // 0x01 = 0b00000001, 0x02 = 0b00000010, 0x03 = 0b00000011, 0x04 = 0b00000100
    private static int i32b = 0b00000001000000100000001100000100;
    
    private int[] i32hs = { 0x01, 0x02 };
    
    public static void main(String[] args) {
        System.out.println("i32h: " + i32h);
        System.out.println("i32b: " + i32b);
        MemStorage ms = new MemStorage();
        System.out.println(ms.i32hs);
    }
    
    public void func() {
        int i2 = 0x02;
        Integer oi3 = 0x03;
    }
}
