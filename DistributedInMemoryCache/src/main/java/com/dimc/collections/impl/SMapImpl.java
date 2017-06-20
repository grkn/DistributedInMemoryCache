package com.dimc.collections.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.dimc.collections.interfaces.SMap;
import com.dimc.pattern.distributed.observer.CoreObserver;
import com.dimc.pattern.distributed.observer.DistributedObserver;
import com.dimc.pattern.distributed.observer.Type;;

public class SMapImpl<K,V> extends HashMap<K, V> implements SMap<K, V>{

	private static CoreObserver coreObserver = new CoreObserver();
	
	static{
		new DistributedObserver(coreObserver);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5866243332213170379L;

	@Override
	public void clear() {
		coreObserver.setState(this,Type.CLEAR);
		super.clear();
	}

	@Override
	public boolean containsKey(Object key) {
	
		return super.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		
		return super.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return super.entrySet();
	}

	@Override
	public V get(Object key) {
		return super.get(key);
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return super.keySet();
	}

	@Override
	public V put(K key, V value) {
		coreObserver.setState(this, Type.PUT);
		return super.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		coreObserver.setState(this, Type.PUT);
		super.putAll(m);
	}

	@Override
	public V remove(Object key) {
		coreObserver.setState(this, Type.REMOVE);
		return super.remove(key);
	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public Collection<V> values() {
		return super.values();
	}

}
