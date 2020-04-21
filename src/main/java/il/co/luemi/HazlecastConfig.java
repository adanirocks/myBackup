/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazlecastConfig {

	/**
	 * The method to Hazel cast config.
	 *
	 * @return the config
	 */
	@Bean
    public Config hazelCastConfig(){
        return new Config()
                .setInstanceName("hazelcast-instance");
                               
    }
	
	
}
