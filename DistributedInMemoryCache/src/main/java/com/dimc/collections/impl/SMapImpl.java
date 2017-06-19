package com.dimc.collections.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.dimc.collections.interfaces.SMap;

public class SMapImpl<K,V> extends HashMap<K, V> implements SMap<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5866243332213170379L;

	@Override
	public void clear() {
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
		return super.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		super.putAll(m);
	}

	@Override
	public V remove(Object key) {
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
