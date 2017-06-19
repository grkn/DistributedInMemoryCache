package com.dimc.pattern.distributed.observer;


import java.io.Serializable;

import com.dimc.collections.interfaces.SMap;

public class DistributedObserver extends Observer {

	public DistributedObserver(CoreObserver core) {
		this.core = core;
		this.core.attach(this);
	}

	@Override
	public void update(Type type) {
		Serializable serialazable = core.getState();
		if(serialazable instanceof SMap){
			switch (type) {
			case CLEAR:
				break;
			case PUT:
				break;
			case REMOVE:
				break;
			case PUTALL:
				break;
			default:
				throw new UnsupportedOperationException();
			}
		}
		
	}

}
