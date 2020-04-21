/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi.exception;

import java.util.List;

import com.mea.bpm.exception.util.ApplicationException;
import com.mea.bpm.response.AdditionalStatus;



/**
 * The Class AppDataTransactionException.
 *
 * @author TCS
 */
public class AppDataTransactionException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The additional status list. */
	List<AdditionalStatus> additionalStatusList;

	/**
	 * Instantiates a new app data transaction exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public AppDataTransactionException(String message, Throwable cause) {
		super(message, cause);
	}

	
	/**
	 * Instantiates a new app data transaction exception.
	 *
	 * @param message the message
	 */
	public AppDataTransactionException(String message) {
		super(message);
	}

	
	/**
	 * Instantiates a new app data transaction exception.
	 *
	 * @param cause the cause
	 */
	public AppDataTransactionException(Throwable cause) {
		super(cause);
	}

	
	/**
	 * Instantiates a new app data transaction exception.
	 *
	 * @param additionalStatus the additional status
	 */
	public AppDataTransactionException(List<AdditionalStatus> additionalStatus) {
		super(additionalStatus);
		this.additionalStatusList = additionalStatus;
	}

	
	/**
	 * Instantiates a new app data transaction exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param additionalStatus the additional status
	 */
	public AppDataTransactionException(String message, Throwable cause, List<AdditionalStatus> additionalStatus) {
		super(message, cause);
		this.additionalStatusList = additionalStatus;
	}

	
	/**
	 * Gets the additional status list.
	 *
	 * @return the additional status list
	 */
	public List<AdditionalStatus> getAdditionalStatusList() {
		return additionalStatusList;
	}

	
	/**
	 * Sets the additional status list.
	 *
	 * @param additionalStatusList the new additional status list
	 */
	public void setAdditionalStatusList(List<AdditionalStatus> additionalStatusList) {
		this.additionalStatusList = additionalStatusList;
	}

}
