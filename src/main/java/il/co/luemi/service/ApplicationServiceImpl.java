/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import il.co.luemi.constants.AppDataConstants;
import il.co.luemi.constants.AppDataErrorConstant;
import il.co.luemi.dao.ApplicationDAO;
import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.exception.AppDataException;
import il.co.luemi.exception.AppDataResourceNotFoundException;
import il.co.luemi.model.GenerateSheetWithColumn;
import il.co.luemi.report.generation.ColumnParameter;
import il.co.luemi.report.generation.ExcelReportGeneration;
import il.co.luemi.report.generation.PDFReportGeneration;
import il.co.luemi.request.CustomerDetailsRequest;
import il.co.luemi.request.mapper.ApplicationRequestMapper;
import il.co.luemi.response.CustomerDetailsResponse;
import il.co.luemi.response.ReportGenerationResponse;
import il.co.luemi.response.mapper.ApplicationResponseMapper;
import il.co.luemi.util.ApplicationMgmtUtil;

/**
 * The Class ApplicationServiceImpl.
 *
 * @author TCS
 */
@Service("ApplicationMgmtService")
public class ApplicationServiceImpl implements ApplicationService {

	/** The application DAO. */
	@Autowired
	ApplicationDAO applicationDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see il.co.luemi.service.ApplicationService#addCoustomerDetails(il.co.luemi.
	 * request.CustomerDetailsRequest)
	 */
	@Override
	public CustomerDetailsResponse addCoustomerDetails(CustomerDetailsRequest customerDetailsRequest) {
		CustomerDetailsResponse customerDetailsResponse = null;

		// Mapping Model to Domain
		CustomerDetails customerDetails = ApplicationRequestMapper
				.mapCustomerDetailsRequestToCustomerDetails(customerDetailsRequest);

		// Persist the data in DB
		customerDetails = applicationDAO.addorUpdateCustomerDetails(customerDetails);
		try {
			if (null != customerDetails) {

				customerDetailsResponse = ApplicationResponseMapper
						.mapCustomerDetailsTocustomerDetailsModel(customerDetails);
			}
		} catch (Exception ex) {
			throw new AppDataException(ex);

		}

		return customerDetailsResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see il.co.luemi.service.ApplicationService#getCustomerDetails(int)
	 */
	@Override
	public CustomerDetailsResponse getCustomerDetails(int customerId) {
		// TODO Auto-generated method stub
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		CustomerDetails customerDetails = applicationDAO.getCustomerDetailsList(customerId);
		try {
			if (null != customerDetails) {
				customerDetailsResponse = customerDetailsResponse = ApplicationResponseMapper
						.mapCustomerDetailsTocustomerDetailsModel(customerDetails);
			}
		} catch (Exception ex) {

			throw new AppDataResourceNotFoundException(AppDataErrorConstant.ERROR_IN_RETRIEVING);
		}
		return customerDetailsResponse;
	}

	public ReportGenerationResponse getcustomerDetailsReport(int reportType )
	{
		ReportGenerationResponse reportGenerationResponse = null;
		try {
			String reportName="customerDetailsReport";
			List<CustomerDetails> customerDetails = applicationDAO.getAllCustomerDetails();
			/*customerDetailsResponse = ApplicationResponseMapper
					.mapCustomerDetailsTocustomerDetailsModel(customerDetails); */
			if (null != customerDetails && !customerDetails.isEmpty()) {
				byte[] generateReport = ExcelReportGeneration.generateReport(reportType, reportName, customerDetails);
				reportGenerationResponse =  new ReportGenerationResponse();
				if(StringUtils.isEmpty(generateReport)) {
					throw new AppDataResourceNotFoundException(AppDataErrorConstant.ERROR_IN_RETRIEVING);
				}

				reportGenerationResponse.setreportData(generateReport);
				return reportGenerationResponse;

			}
		}
		catch (Exception e) {
			throw new AppDataResourceNotFoundException(AppDataErrorConstant.ERROR_IN_RETRIEVING);

		}
		return reportGenerationResponse;


	}

	@Override
	public CustomerDetailsResponse getCustomersReport(int reportId, String reportName)
			throws NoSuchFieldException, SecurityException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


}

/*public CustomerDetailsResponse getgrantsReport(int reportType)
		throws NoSuchFieldException, SecurityException, IOException {
	CustomerDetailsResponse customerDetailsResponse = null;
	try {

		 String reportName = "grantsReport";
		List<CustomerDetails> customerDetails = applicationDAO.getAllCustomerDetails();
		customerDetailsResponse = ApplicationResponseMapper
				.mapCustomerDetailsTocustomerDetailsModel(customerDetails); 
		if (null != customerDetails && !customerDetails.isEmpty()) {
		generateReport(reportType, reportName, customerDetails);
		}

		catch (Exception e) {
			throw new AppDataResourceNotFoundException(AppDataErrorConstant.ERROR_IN_RETRIEVING);

		}
		return customerDetailsResponse;


}

}*/


