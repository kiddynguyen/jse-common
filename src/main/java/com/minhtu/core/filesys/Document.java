package com.minhtu.core.filesys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tunm2
 */
public class Document {
    
    private String name;
    private List<String> lines = new ArrayList<>();
    
    public Document(String filename) {
        this.name = filename;
        
        BufferedReader buffer = null;
        try {
            FileReader reader = new FileReader(name);
            buffer = new BufferedReader(reader);
            
            String line;
            while ((line = buffer.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                buffer.close();
            } catch (IOException ioe) {}
        }
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
    
}
