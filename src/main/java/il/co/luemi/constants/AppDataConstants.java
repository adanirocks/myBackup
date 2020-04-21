/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi.constants;


/**
 * The Class AppDataConstants.
 *
 * @author TCS
 */
public class AppDataConstants {

	/**
	 * Instantiates a new App data constants.
	 */
	private AppDataConstants() {
		super();
	}

	/** The Constant CONFIG_BASE_LOCATIONS. */
	public static final String CONFIG_BASE_LOCATIONS = "config/AppDataMgmt-config.properties";

	/** The Constant APP_ERROR_FILE. */
	public static final String APP_ERROR_FILE = "error/application-error";


	/** The Constant APP_SYSTEM. */
	public static final String APP_SYSTEM = "App Data Management";

	/** The Constant APP_RUN_TIME_EXCEPTION. */
	public static final String APP_RUN_TIME_EXCEPTION = "APP_RUN_TIME_EXCEPTION";

	/** The Constant EGEN_1001. */
	public static final String EGEN_1001 = "Application is experiencing a error";

	/** The Constant EGEN_1002. */
	public static final String EGEN_1002 = "Application is experiencing a error.";

	/** The Constant ERROR_TYPE. */
	public static final String ERROR_TYPE = "ERROR_TYPE";

	/** The Constant TRANSACTION_ERROR_CODE. */
	public static final String TRANSACTION_ERROR_CODE = "2";

	/** The Constant VALIDATION_ERROR_CODE. */
	public static final String VALIDATION_ERROR_CODE = "1";

	/** The Constant TRANSACTION_ERROR_DESC. */
	public static final String TRANSACTION_ERROR_DESC = "Trasnsactional Error";

	/** The Constant VALIDATION_ERROR_DESC. */
	public static final String VALIDATION_ERROR_DESC = "Validation Error";

	/** The Constant WARN_TYPE. */
	public static final String WARN_TYPE = "Warning";

	/** The Constant INVALID_NUMBER. */
	public static final String INVALID_NUMBER = "Invalid Number";

	/** The Constant ACTION_EVENT_VIEW. */
	public static final String ACTION_EVENT_VIEW = "R";

	/** The Constant ACTION_EVENT_DELETE. */
	public static final String ACTION_EVENT_DELETE = "D";

	/** The Constant ACTION_EVENT_EDIT. */
	public static final String ACTION_EVENT_EDIT = "U";

	/** The Constant ACTION_EVENT_ADD. */
	public static final String ACTION_EVENT_ADD = "A";

	/** The Constant ACTIVE. */
	public static final Object ACTIVE = "ACT";

	/** The Constant INACTIVE. */
	public static final Object INACTIVE = "INACT";

	/** The Constant DATE_FORMAT. */
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	/** The Constant HEADERS. */
	public static final String HEADERS = "headers";

	/** The Constant STATUS_CODE. */
	public static final String STATUS_CODE = "statusCode";

	/** The Constant MODULE. */
	public static final String MODULE = "APP";
	
	/** The Constant APPLICATION_ID. */
	public static final String APPLICATION_ID = "applicationId";
	
	/** The Constant END_DATE_VALUE. */
	public static final String END_DATE_VALUE = "endDate value";
    
	public static final String CUSTOMERDETAILS_REPORT_LOCATION="D:\\Backend\\CustomerDetails.xls";
	public static final String REPORT_GENERATION_CONFIG_FILE_LOCATION= "src\\main\\resources\\ReportGeneration.xml";
}
