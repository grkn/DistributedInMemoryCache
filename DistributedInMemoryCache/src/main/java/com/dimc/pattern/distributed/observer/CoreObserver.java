package com.dimc.pattern.distributed.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoreObserver {

	private List<Observer> observers = new ArrayList<Observer>();
	private Serializable serializableMap;

	public Serializable getState() {
		return serializableMap;
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers(Type type) {
		for (Observer observer : observers) {
			observer.update(type);
		}
	}

	public void setState(Serializable state, Type type) {
		// TODO Auto-generated method stub
		this.serializableMap= state;
		notifyAllObservers(type);
	}
}
