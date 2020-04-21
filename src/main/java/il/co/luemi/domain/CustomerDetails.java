/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hazelcast.nio.serialization.Serializer;

/**
 * The Class CustomerDetails.
 *
 * @author TCS
 */
@Entity
@Table(name = "CUSTOMERDETAILS")
@NamedQuery(name = "CustomerDetails.findAll", query = "SELECT a FROM CustomerDetails a ORDER BY customerId")
public class CustomerDetails implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The customer id. */
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	/** The name. */
	@Column(name = "NAME")
	private String name;  
	
	/** The eamil id. */
	@Column(name = "EMAIL_ID")
	private String eamilId;	  
	
	/** The mobile no. */
	@Column(name = "MOBILE_NO")
	private BigInteger mobileNo;
	
	/** The address. */
	@Column(name = "ADDRESS")
	private String address; 
	
	/** The pan no. */
	@Column(name = "PAN_NO")
	private String panNo;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", name=" + name + ", eamilId=" + eamilId + ", mobNo="
				+ mobileNo + ", address=" + address + ", panNo=" + panNo + "]";
	}

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
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public BigInteger getMobileNo() {
		return mobileNo;
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
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
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
