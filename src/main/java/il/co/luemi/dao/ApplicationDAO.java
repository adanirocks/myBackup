/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.dao;

import java.util.List;

import il.co.luemi.domain.CustomerDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface ApplicationDAO.
 *
 * @author TCS
 */
public interface ApplicationDAO {

	  /**
  	 * The method to Addor update customer details.
  	 *
  	 * @param customerDetails the customer details
  	 * @return the customer details
  	 */
  	CustomerDetails addorUpdateCustomerDetails(CustomerDetails customerDetails);

	/**
	 * Gets the customer details list.
	 *
	 * @param customerId the customer id
	 * @return the customer details list
	 */
	CustomerDetails getCustomerDetailsList(int customerId);

	List<CustomerDetails> getAllCustomerDetails();

	

}
