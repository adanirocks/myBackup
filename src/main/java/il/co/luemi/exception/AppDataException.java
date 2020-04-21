/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi.exception;

import com.mea.bpm.exception.util.ApplicationException;


// TODO: Auto-generated Javadoc
/**
 * The Class AppDataException.
 *
 * @author TCS
 */
public class AppDataException extends ApplicationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new App data exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public AppDataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new App data exception.
	 *
	 * @param message
	 *            the message
	 */
	public AppDataException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new App data exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public AppDataException(Throwable cause) {
		super(cause);
	}

}
