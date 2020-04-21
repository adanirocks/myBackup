/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.util; /**
							
							* This software is the proprietary to TCS.
							* Use is subject to license terms.
							*/

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.mea.bpm.constants.GeneralResponseCode;
import com.mea.bpm.constants.GeneralResponseDescription;
import com.mea.bpm.enums.MessageType;
import com.mea.bpm.response.BaseResponse;
import com.mea.bpm.response.Status;

import il.co.luemi.ApplicationManagement;
import il.co.luemi.constants.AppDataConstants;
import il.co.luemi.constants.AppDataThreadContext;
import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.report.generation.ColumnParameter;
import il.co.luemi.report.generation.ReportGeneration;

/**
 * The Class Util.
 *
 * @author TCS
 */
public class ApplicationMgmtUtil {
	
	private  static final  Logger LOG = LogManager.getLogger(ApplicationMgmtUtil.class);

	/**
	 * Instantiates a new application mgmt util.
	 */
	private ApplicationMgmtUtil() {
		super();
	}

	/**
	 * Map response to baseresponse.
	 *
	 * @param input the input
	 * @return the object
	 */
	public static Object mapResponseToBaseresponse(Object input) {
		// AppDataThreadContext.setRequestId(customerDetailsRequest.getUuid());
		((BaseResponse) input).setRequestId(AppDataThreadContext.getRequestId());
		((BaseResponse) input).setSessionId(AppDataThreadContext.getSessionId());
		Status status = new Status();
		status.setStatusCode(GeneralResponseCode.SUCCES_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.SUCCES_STATUS_DESC);
		status.setSeverity(MessageType.INFO.toString());
		status.setSystem(AppDataConstants.APP_SYSTEM);
		((BaseResponse) input).setStatus(status);
		return input;
	}

	/**
	 * Convert string to date.
	 *
	 * @param dateString the date string
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date convertStringToDate(String dateString) throws ParseException {
		if (dateString != null) {
			DateFormat sdfDate = new SimpleDateFormat(AppDataConstants.DATE_FORMAT);
			return sdfDate.parse(dateString);
		} else {
			return null;
		}
	}

	public static ReportGeneration loadConfig() {
		File file = new File(AppDataConstants.REPORT_GENERATION_CONFIG_FILE_LOCATION);
		ReportGeneration rg = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ReportGeneration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			rg = (ReportGeneration) jaxbUnmarshaller.unmarshal(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rg;

	}
	
	public static byte[] getByteContent(HSSFWorkbook workbook) throws IOException {
		 
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    workbook.write(baos); 
	    return baos.toByteArray();
	}
}
