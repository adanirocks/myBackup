/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.response;

import java.util.List;

import com.mea.bpm.response.BaseResponse;

import il.co.luemi.model.CustomerDetails;


/**
 * The Class CustomerDetailsResponse.
 *
 * @author TCS
 */
public class CustomerDetailsResponse extends BaseResponse  {
	
	/** The customer details. */
	private CustomerDetails customerDetails;
	private List<CustomerDetails> customerDetailsModel;

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

	public void setCustomerDetails(List<CustomerDetails> customerDetailsModel) {
		// TODO Auto-generated method stub
		this.customerDetailsModel=customerDetailsModel;
	}

	public List<CustomerDetails> getCustomerDetailsModel() {
		return customerDetailsModel;
	}

	public void setCustomerDetailsModel(List<CustomerDetails> customerDetailsModel) {
		this.customerDetailsModel = customerDetailsModel;
	}

	
	

}
