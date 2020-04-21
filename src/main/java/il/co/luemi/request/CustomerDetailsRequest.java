/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.request;

import javax.validation.Valid;

import com.mea.bpm.request.BaseRequest;

import il.co.luemi.model.CustomerDetails;


/**
 * The Class CustomerDetailsRequest.
 *
 * @author TCS
 */
public class CustomerDetailsRequest extends BaseRequest {
	
	
	/** The customer details. */
	private @Valid CustomerDetails customerDetails;

	/**
	 * Gets the customer details.
	 *
	 * @return the customer details
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * Sets the customer details.
	 *
	 * @param customerDetails the new customer details
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	

}
