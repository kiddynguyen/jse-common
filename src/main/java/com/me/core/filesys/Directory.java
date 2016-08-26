package com.me.core.filesys;

import java.util.List;

/**
 * @author tunm2
 */
public class Directory {
    
    private String name;
    private List<Document> documents;
    private List<Directory> subdirs;
    
    public Directory(String path) {
        this.name = path;
        
        
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Directory> getSubdirs() {
        return subdirs;
    }

    public void setSubdirs(List<Directory> subdirs) {
        this.subdirs = subdirs;
    }
    
    
}
