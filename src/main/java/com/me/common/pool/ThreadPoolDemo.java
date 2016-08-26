package com.me.common.pool;

/**
 *
 * @author tunm2
 */
public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		ThreadPool pool = ThreadPool.INSTANCE;
		Thread obj = pool.borrowObject();
		
		System.out.println(pool.toString());
	}
	
}
