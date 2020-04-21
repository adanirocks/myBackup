/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.response.mapper;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import il.co.luemi.ApplicationManagement;
import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.mapper.ApplicationMapper;
import il.co.luemi.response.CustomerDetailsResponse;
import il.co.luemi.util.ApplicationMgmtUtil;

/**
 * The Class ApplicationResponseMapper.
 *
 * @author TCS
 */
public class ApplicationResponseMapper {
	
	private  static final  Logger LOG = LogManager.getLogger(ApplicationResponseMapper.class);

	/**
	 * Instantiates a new application response mapper.
	 */
	private  ApplicationResponseMapper() {
		
	}

	/**
	 * The method to Map customer details to customer details model.
	 *
	 * @param customerDetails the customer details
	 * @return the customer details response
	 */
	public static CustomerDetailsResponse mapCustomerDetailsTocustomerDetailsModel(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		il.co.luemi.model.CustomerDetails customerDetailsModel;
		
	//	Converting Domain to Model 
		customerDetailsModel = ApplicationMapper.INSTANCE.mapCustomerDetailsDomainToCustomerDetails(customerDetails);
		 customerDetailsResponse.setCustomerDetails(customerDetailsModel);
		 
		 //Convert To Base Response
		 
		customerDetailsResponse = (CustomerDetailsResponse) ApplicationMgmtUtil.
			 mapResponseToBaseresponse(customerDetailsResponse);
				
		return customerDetailsResponse;		
		
	}

	/**
	 * The method to Map customer details to customer details model.
	 *
	 * @param ListcustomerDetails the customer details
	 * @return the customer details response
	 */
	public static CustomerDetailsResponse mapCustomerDetailsTocustomerDetailsModel(
			List<CustomerDetails> customerDetails) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		 
		
		
//		Converting Domain to Model 
			List<il.co.luemi.model.CustomerDetails> customerDetailsModel = ApplicationMapper.INSTANCE.mapCustomerDetailsDomainToCustomerDetails(customerDetails);
			 customerDetailsResponse.setCustomerDetails(customerDetailsModel);
			 
			//Convert To Base Response
			 
				customerDetailsResponse = (CustomerDetailsResponse) ApplicationMgmtUtil.
					 mapResponseToBaseresponse(customerDetailsResponse);
				
		return customerDetailsResponse;
	}

}


