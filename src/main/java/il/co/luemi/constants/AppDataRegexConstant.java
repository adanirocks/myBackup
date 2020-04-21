/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.constants;


/**
 * The Class AppDataRegexConstant.
 *
 * @author TCS
 */
public class AppDataRegexConstant {
	
	/** The Constant EMAIL_REGEX. */
	public static final String EMAIL_REGEX="^[A-Za-z0-9+_.-]+@(.+)$";
	
	/** The Constant NUMBER_RANGE_REGEX. */
	public static final String NUMBER_RANGE_REGEX= "^[0-9]{10}";
	
	/** The Constant ALPHANUMERIC_REGEX. */
	public static final String ALPHANUMERIC_REGEX="^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";
	
	/** The Constant ALPHANUMERIC_WITH_SPACE_REGEX. */
	public static final String ALPHANUMERIC_WITH_SPACE_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9 ]+)$";
	
	/** The Constant ALPHABET_ONLY. */
	public static final String ALPHABET_ONLY= "[a-zA-Z]*";
	
	/** The Constant ALPHABET_ONLY_WITHSPACE. */
	public static final String ALPHABET_ONLY_WITHSPACE = "[a-zA-Z a-zA-Z ]*";
}
