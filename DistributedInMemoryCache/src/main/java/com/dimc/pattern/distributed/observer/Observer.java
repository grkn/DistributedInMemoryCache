package com.dimc.pattern.distributed.observer;

public abstract class Observer {
	protected CoreObserver core;
	public abstract void update(Type type);
}
