/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hazelcast.core.IMap;


import il.co.luemi.constants.AppDataErrorConstant;
import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.exception.AppDataTransactionException;
import il.co.luemi.util.HazelConfig;

// 
/**
 * The Class ApplicationDaoImpl.
 *
 * @author TCS
 */
@Repository
@EnableTransactionManagement
@Transactional
public class ApplicationDaoImpl implements ApplicationDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The hazel config. */
	@Autowired
	HazelConfig hazelConfig;

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(ApplicationDaoImpl.class);

	/*
	 * (non-Javadoc) This method Persist The Data in DB
	 * 
	 * @see
	 * il.co.luemi.dao.ApplicationDAO#addorUpdateCustomerDetails(il.co.luemi.domain.
	 * CustomerDetails)
	 */
	@Override
	public CustomerDetails addorUpdateCustomerDetails(CustomerDetails customerDetails) {

		try {
			if (customerDetails.getCustomerId() == 0) {
				entityManager.persist(customerDetails);
			} else {
				entityManager.merge(customerDetails);
			}
		} catch (Exception e) {
			LOG.info("ERROR_IN_SAVING");
			throw new AppDataTransactionException(AppDataErrorConstant.ERROR_IN_SAVING);
		}
		return customerDetails;
	}

	/*
	 * (non-Javadoc) This method fetch Customerdetails by id and saved it in cache
	 * 
	 * @see il.co.luemi.dao.ApplicationDAO#getCustomerDetailsList(int)
	 */
	@Override
	@Cacheable(value = "Customerdetails")
	public CustomerDetails getCustomerDetailsList(int customerId) {
		// TODO Auto-generated method stub
		CustomerDetails customerDetails = null;

		System.out.println("Inside DB Call");
		try {
			if (customerId != 0) {
				customerDetails = entityManager.find(CustomerDetails.class, customerId);
				IMap<Object, Object> customerdetailshazel = hazelConfig.getMapConfig("Customerdetails");

				customerdetailshazel.put(customerDetails.getCustomerId(), customerDetails);
			}
		} catch (Exception ex) {
			if (customerDetails == null) {

				throw new AppDataTransactionException(AppDataErrorConstant.DATA_NOT_FOUND);
			}
		}

		return customerDetails;
	}

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		
		List<CustomerDetails> customerDetails = null;
		try {
			
			customerDetails = entityManager.createNamedQuery("CustomerDetails.findAll", CustomerDetails.class).getResultList();
			//customerDetails = entityManager.createNamedQuery("CustomerDetails.findAll", CustomerDetails.class).getResultList();		
		} 
		catch (Exception e) {

			throw new AppDataTransactionException(AppDataErrorConstant.ERROR_IN_RETRIEVING);
		}

		return customerDetails;
	}
		
}
