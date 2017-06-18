package com.dimc.collections.interfaces;

import java.io.Serializable;
import java.util.Map;
/**
 * 
 * In Memory Map which is distributed
 * @author grkn
 *
 * @param <K> Key 
 * @param <V> Value
 */
public interface SMap<K,V> extends Map<K, V>,Serializable{

}
