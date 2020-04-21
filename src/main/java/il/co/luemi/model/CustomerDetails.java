/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.validation.annotation.Validated;

import il.co.luemi.constants.AppDataRegexConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * The Class CustomerDetails.
 *
 * @author TCS
 */
@Validated
@ApiModel(description = "CustomerDetails Model")
public class CustomerDetails {

	/** The customer id. */
	@ApiModelProperty(value = "Customer Id", required = true)

	private int customerId;
	
	/** The name. */
	@ApiModelProperty(value = "Name of the Customer", required = true)
	@Pattern(regexp=AppDataRegexConstant.ALPHABET_ONLY,message="Name is not in proper format")
	private String name;
	
	/** The eamil id. */
	@ApiModelProperty(value = "EamilId", required = true)
	@Email
	private String eamilId;
	
	/** The mob no. */
	@ApiModelProperty(value = "MobNo", required = true)
	@Pattern(regexp=AppDataRegexConstant.NUMBER_RANGE_REGEX,message="MOB number should be 10 digit") 
	private String mobNo;
	
	/** The address. */
	@ApiModelProperty(value = "Address", required = true)
	private String address;
	
	/** The pan no. */
	@ApiModelProperty(value = "Pan Id", required = true)
	@Pattern(regexp=AppDataRegexConstant.ALPHANUMERIC_REGEX,message="Pan Number is Not Valid")
	@NotNull
	private String panNo;
	
	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the eamil id.
	 *
	 * @return the eamil id
	 */
	public String getEamilId() {
		return eamilId;
	}
	
	/**
	 * Sets the eamil id.
	 *
	 * @param eamilId the new eamil id
	 */
	public void setEamilId(String eamilId) {
		this.eamilId = eamilId;
	}
	
	/**
	 * Gets the mob no.
	 *
	 * @return the mob no
	 */
	public String getMobNo() {
		return mobNo;
	}
	
	/**
	 * Sets the mob no.
	 *
	 * @param mobNo the new mob no
	 */
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the pan no.
	 *
	 * @return the pan no
	 */
	public String getPanNo() {
		return panNo;
	}
	
	/**
	 * Sets the pan no.
	 *
	 * @param panNo the new pan no
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	
}
