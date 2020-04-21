/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.service;

import java.io.IOException;

import il.co.luemi.request.CustomerDetailsRequest;
import il.co.luemi.response.CustomerDetailsResponse;
import il.co.luemi.response.ReportGenerationResponse;


/**
 * The Interface ApplicationService.
 *
 * @author TCS
 */
public interface ApplicationService {

	 /**
 	 * The method to Adds the coustomer details.
 	 *
 	 * @param customerDetailsRequest the customer details request
 	 * @return the customer details response
 	 */
 	CustomerDetailsResponse addCoustomerDetails( CustomerDetailsRequest customerDetailsRequest);

	/**
	 * Gets the customer details.
	 *
	 * @param customerId the customer id
	 * @return the customer details
	 */
	CustomerDetailsResponse getCustomerDetails(int customerId);

	CustomerDetailsResponse getCustomersReport(int reportId, String reportName) throws NoSuchFieldException, SecurityException, IOException;

	ReportGenerationResponse getcustomerDetailsReport(int reportType);

	
		
		
	

}
