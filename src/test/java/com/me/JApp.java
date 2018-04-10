package com.me;

/**
 *
 * @author tunm2
 */
public class JApp {
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println("hello world");
        
        JApp japp = JApp.class.newInstance();
        System.out.println(japp);
    }
    
}
