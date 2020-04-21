/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.core.Ordered;

import il.co.luemi.constants.AppDataConstants;
import il.co.luemi.constants.AppDataThreadContext;

/**
 * The Class RequestFilter.
 *
 * @author TCS
 */
public class RequestFilter implements Filter, Ordered {

	/** The Constant LOGGER. */
	private static final Logger LOG = LogManager.getLogger(RequestFilter.class);

	
	/** The order. */
	private int order = Ordered.LOWEST_PRECEDENCE - 20;


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
            LOG.info("Inside doFilter");
			AppDataThreadContext.setUserName("Test");

			AppDataThreadContext.setModule(AppDataConstants.MODULE);
			chain.doFilter(request, response);
		} finally {
			ThreadContext.clearAll();

		}

	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init method

	}


	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// destroy method

	}

	
	/* (non-Javadoc)
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder() {
		return order;
	}

}