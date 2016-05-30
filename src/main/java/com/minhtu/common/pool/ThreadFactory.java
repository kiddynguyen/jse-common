/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.minhtu.common.pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 *
 * @author tunm2
 */
public class ThreadFactory extends BasePoolableObjectFactory<Thread> {

	@Override
	public Thread makeObject() throws Exception {
		return new Thread();
	}

}
