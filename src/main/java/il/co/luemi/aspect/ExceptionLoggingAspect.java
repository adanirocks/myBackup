/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * The Class ExceptionLoggingAspect.
 *
 * @author TCS
 */
@Aspect
@Component
public class ExceptionLoggingAspect {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ExceptionLoggingAspect.class);

	/**
	 * Log after throwing.
	 *
	 * @param ex
	 *            the ex
	 */
	@AfterThrowing(pointcut = "within(il.com.luemi.*.*) && execution(* il.com.luemi.*.*.*(..))", throwing = "ex")
	public void logAfterThrowing(Exception ex) {
		if (LOGGER.isDebugEnabled()) {
			// Logging complete stacktrace in better format
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			LOGGER.error((sw.toString()));
		}

	}

}