package com.dimc.executors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.dimc.netty.server.Server;

public class ExpandableThreadPool extends ThreadPoolExecutor{

	private ExpandableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public final static  class Builder{
		private int coorPoolSize = Server.THREAD_COUNT_SERVER;
		private int maximumPoolSize = Server.MAX_THREAD_COUNT;
		private long keepAliveTime = 2000;//Two seconds for each threads  for maximum idle timeout
		private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
		
		public Builder setCoorPoolSize(int coorPoolSize) {
			this.coorPoolSize = coorPoolSize;
			return this;
		}
		
		public Builder setMaximumPoolSize(int maximumPoolSize) {
			this.maximumPoolSize = maximumPoolSize;
			return this;
		}
		 
		public Builder setKeepAliveTime(long keepAliveTime) {
			this.keepAliveTime = keepAliveTime;
			return this;
		}
		
		public Builder setTimeUnit(TimeUnit timeUnit) {
			this.timeUnit = timeUnit;
			return this;
		}
		
		public ExpandableThreadPool build(){
			return new ExpandableThreadPool(coorPoolSize, maximumPoolSize, keepAliveTime, timeUnit,new SynchronousQueue<Runnable>());
		}
	}
	
}
