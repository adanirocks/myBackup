/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.mapper;

import java.math.BigInteger;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


import il.co.luemi.domain.CustomerDetails;


// TODO: Auto-generated Javadoc
/**
 * The Interface ApplicationMapper.
 *
 * @author TCS
 */
@Mapper(componentModel = "spring")
public interface ApplicationMapper {
	
	/** The instance. */
	ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
	

	
	/**
	 * The method to Map customer details resquest to customer details.
	 *
	 * @param customerDetailsResquest the customer details resquest
	 * @return the customer details
	 */
	@Mapping(target = "mobileNo", source = "mobNo", qualifiedByName = "stringToInteger")
	public CustomerDetails mapCustomerDetailsResquestToCustomerDetails (il.co.luemi.model.CustomerDetails customerDetailsResquest);
	
	/**
	 * The method to Map customer details domain to customer details.
	 *
	 * @param customerDetails the customer details
	 * @return the il.co.luemi.model. customer details
	 */
	@Mapping(target = "mobNo", source = "mobileNo" ,qualifiedByName = "integerToString")
	public il.co.luemi.model.CustomerDetails mapCustomerDetailsDomainToCustomerDetails(CustomerDetails customerDetails);
	
	/**
	 * The method to Str to integer.
	 *
	 * @param List<CustomerDetails> the customer details
	 * @return the big integer
	 */
	@IterableMapping(qualifiedByName = "integerToString")
	
	public List <il.co.luemi.model.CustomerDetails> mapCustomerDetailsDomainToCustomerDetails(
			List<CustomerDetails> customerDetails);
	

	
	/**
	 * The method to Integer to string.
	 *
	 * @param mobNo the mob no
	 * @return the string
	 */
	@Named("integerToString")
	public static String integerToString(BigInteger mobNo) {
		return mobNo.toString() ;
	}


}
