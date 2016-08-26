package com.me.core.encoding;

import java.nio.charset.StandardCharsets;

/**
 * <link>http://www.joelonsoftware.com/articles/Unicode.html</link>
 * 
 * @author tunm2
 */
public class CharacterEncoding {
    
    static String strEn = "abc";
    static String strVi = "test thôi mà";
    
    public static void main(String[] args) {
        byte[] bytes = strVi.getBytes();
    }
    
    // 7bits for each character
    static byte[] encodeASCII(String string) {
        return string.getBytes(StandardCharsets.US_ASCII);
    }

    // variable length encoding, 1-4bytes for each character
    static byte[] encodeUTF8(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    // 2bytes for each character and 2bytes for presenting BYTE ORDER
    static byte[] encodeUTF16(String string) {
        return string.getBytes(StandardCharsets.UTF_16);
    }
    
    // 2bytes for each character, BIG ENDIAN BYTE ORDER
    static byte[] encodeUTF16BE(String string) {
        return string.getBytes(StandardCharsets.UTF_16BE);
    }
    
    // 2bytes for each character, LITTLE ENDIAN BIT ORDER
    static byte[] encodeUTF16LE(String string) {
        return string.getBytes(StandardCharsets.UTF_16LE);
    }
}
