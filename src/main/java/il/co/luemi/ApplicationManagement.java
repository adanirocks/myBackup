/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.mea.bpm.configuration.util.PropertyConfigUtil;
import com.mea.bpm.resource.util.MessageUtils;

import il.co.luemi.constants.AppDataConstants;

/**
 * The Class ApplicationManagement.
 *
 * @author TCS
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
public class ApplicationManagement {

	
	/** The Constant LOG. */
	private  static final  Logger LOG = LogManager.getLogger(ApplicationManagement.class);
	

	static{
		try {
			String[] baseLocation = {AppDataConstants.CONFIG_BASE_LOCATIONS};
			PropertyConfigUtil.getInstance(baseLocation);
			MessageUtils.registerResource(AppDataConstants.APP_ERROR_FILE);
			} catch (Exception exception) {
				LOG.error("Error loading Configuration Files",exception);
		}
	}
	
	/**
	 * The entry point to the microservices.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationManagement.class, args);
			
	}

}
