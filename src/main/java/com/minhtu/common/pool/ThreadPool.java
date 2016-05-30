/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.minhtu.common.pool;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 *
 * @author tunm2
 */
public class ThreadPool extends GenericObjectPool<Thread> {
	
	private static final int POOL_SIZE = 10;
    private static PoolableObjectFactory factory = new ThreadFactory();
    
	public static final ThreadPool INSTANCE = new ThreadPool();
	
	private ThreadPool() {
		super(factory, POOL_SIZE);
	}
	
    @Override
	public Thread borrowObject() {
		try {
			return super.borrowObject();
		} catch (Exception ex) {
			Logger.getLogger(ThreadPool.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
	}
	
    @Override
	public void returnObject(Thread object) {
		try {
			super.returnObject(object);
		} catch (Exception ex) {
			Logger.getLogger(ThreadPool.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
