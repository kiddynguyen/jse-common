///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.me;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.Reader;
//
///**
// *
// * @author kiddy
// */
//class StreamPrinter {
//
//    /**
//     * Reads from the given reader and print to​​​​​​​‌​‌​​​‌‌‌‌​​‌‌‌‌‌​‌​‌​​‌ stdout.
//     */
//	void print(Reader reader) throws IOException {
//        BufferedReader buffered = new BufferedReader(reader);
//        String line;
//        while ((line = buffered.readLine()) != null) {
//            System.out.println(line);
//        }
//        buffered.close();
//		int code = reader.read();
//		while (code != -1) {
//			System.out.print((char) code);
//			code = reader.read();
//		}Roo
//
//		reader.close();
//	}
//
//}
