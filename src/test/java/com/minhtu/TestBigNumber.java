package com.minhtu;

import java.math.BigInteger;

/**
 *
 * @author tunm2
 */
public class TestBigNumber {
    
    private static int DIGITS = 50;
    
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        
        StringBuilder strBigInt = new StringBuilder();
        for (int i = 1; i <= DIGITS; i++)
            strBigInt.append(i);
        
        BigInteger bigint = new BigInteger(strBigInt.toString());
        System.out.println(bigint);
        System.out.println(bigint.mod(BigInteger.valueOf(Long.MAX_VALUE)));
    }
}
