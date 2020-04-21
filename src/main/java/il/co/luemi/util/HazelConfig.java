/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * The Class HazelConfig.
 *
 * @author TCS
 */
@Component
public class HazelConfig {

	
	
	/**
	 * Gets the map config.
	 *
	 * @param configName the config name
	 * @return the map config
	 */
	public IMap<Object, Object> getMapConfig(String configName) {
		
		HazelcastInstance hazelcastInstanceByName = Hazelcast.getHazelcastInstanceByName("hazelcast-instance");
		hazelcastInstanceByName.getConfig().addMapConfig(new MapConfig().setName(configName)
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
				.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(3000));
		 return hazelcastInstanceByName.getMap(configName);
	}
	
	
	/**
	 * Gets the cache details.
	 *
	 * @param cacheName the cache name
	 * @return the cache details
	 */
	public IMap<Object, Object> getCacheDetails(String cacheName) {
		HazelcastInstance hazelcastInstanceByName = Hazelcast.getHazelcastInstanceByName("hazelcast-instance");
		return hazelcastInstanceByName.getMap(cacheName);
	}
}
