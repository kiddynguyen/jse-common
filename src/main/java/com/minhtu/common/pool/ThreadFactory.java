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
