package com.me.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class TextFileIO {
    
    static final int EOF = -1;

    public static void main(String[] args) {
        
    }
    
    static void copy(String fromFileName, String toFileName) throws IOException {
        File fi = new File(fromFileName);
        FileInputStream fis = new FileInputStream(fi);
        
        File fo = new File(toFileName);
        FileOutputStream fos = new FileOutputStream(fo);
        
        int b;
        while ((b = fis.read()) != EOF) {
            fos.write(b);
        }
        
        fis.close();
        fos.close();
    }
    
    static List<String> readLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        
        File fi = new File(fileName);
        FileInputStream fis = new FileInputStream(fi);
        int b;
        
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int lineSize = 0;
        byte[] bytes = new byte[1024];
        while ((b = fis.read()) != EOF) {
            buffer.put((byte) b);
            lineSize++;
            if (b == '\n') {
                buffer.get(bytes, b, lineSize);
                lineSize = 0;
            }
        }
        
        return null;
    }
}
