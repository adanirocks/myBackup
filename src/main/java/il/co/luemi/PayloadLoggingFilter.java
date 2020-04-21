/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;



/**
 * The Class PayloadLoggingFilter.
 *
 * @author TCS
 */
@Component
public class PayloadLoggingFilter extends PayloadFilter{

	/** The logger used for Instrumentation and Auditing purposes. */
	private static final Logger LOG = LogManager.getLogger(PayloadLoggingFilter.class);
	
	
	/* (non-Javadoc)
	 * @see il.co.luemi.PayloadFilter#logTrace(java.util.Map)
	 */
	@Override
	protected void logTrace(Map<String, Object> trace){
		LOG.info(trace);
	}

    /**
	 * The method to REQUEST/RESPONSE and Log trace.
	 *
	 * @param messageType
	 *            the message type
	 * @param trace
	 *            the trace
	 */
	@Override
    protected void logTrace(String messageType, Map<String, Object> trace) {
    	 LOG.info("{} {}", messageType, trace);
    }	
}
