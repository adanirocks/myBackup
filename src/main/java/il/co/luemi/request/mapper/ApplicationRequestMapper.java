/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.request.mapper;

import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.mapper.ApplicationMapper;
import il.co.luemi.request.CustomerDetailsRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationRequestMapper.
 *
 * @author TCS
 */
public class ApplicationRequestMapper {

	/**
	 * Instantiates a new application request mapper.
	 */
	private ApplicationRequestMapper() {
	}
	
	
	/**
	 * The method to Map customer details request to customer details.
	 *
	 * @param customerDetailsRequest the customer details request
	 * @return the customer details
	 */
	public static CustomerDetails mapCustomerDetailsRequestToCustomerDetails(CustomerDetailsRequest customerDetailsRequest)
	{
		CustomerDetails customerDetails;
		
		//Storing User INPUT Data as a model inside customerDetailsModel
		
		il.co.luemi.model.CustomerDetails customerDetailsModel = customerDetailsRequest.getCustomerDetails();
		
	//	Converting Model to Domain 
		customerDetails = ApplicationMapper.INSTANCE.mapCustomerDetailsResquestToCustomerDetails(customerDetailsModel);
				
		
		return customerDetails;
		
	}
	
	
}
