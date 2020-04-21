/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.controller;
import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.IMap;

import il.co.luemi.exception.AppDataException;
import il.co.luemi.request.CustomerDetailsRequest;
import il.co.luemi.response.CustomerDetailsResponse;
import il.co.luemi.response.ReportGenerationResponse;
import il.co.luemi.service.ApplicationService;
import il.co.luemi.util.HazelConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

;

/**
 * The Class ApplicationController.
 *
 * @author TCS
 */
@RestController
@RequestMapping("/application/v1")
@Api(value = "Application Management")
public class ApplicationController {
	
	/** The application service. */
	@Autowired
	ApplicationService applicationService;
	
	/** The hazel config. */
	@Autowired
	HazelConfig  hazelConfig;

/**
 * The method will return  Hello world.
 *
 * @return the string
 */
@ApiOperation(value = "Hello World ")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Fields are with validation errors"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Error occurred while deleting File") })
@GetMapping("/applicationsDetails")

public String HelloWorld()

{
	return "Hello World";
}

/**
 * It will add the CustomerDetails in DB .
 *
 * @param customerDetailsRequest the customer details request
 * @throws AppDataException
 * @throws 
 * @return the customer details response
 */
@ApiOperation(value = "Add Customer Details ")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Added Customer Details"),
		@ApiResponse(code = 400, message = "Fields are with validation errors"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Error occurred while deleting File") })
@PostMapping("/addCustomerDetails")
@Consumes("application/json")
@Produces("application/json")
public CustomerDetailsResponse addCustomerDetails(@Valid @RequestBody CustomerDetailsRequest customerDetailsRequest) {
	
	CustomerDetailsResponse customerDetailsResponse = applicationService.addCoustomerDetails(customerDetailsRequest);
	return customerDetailsResponse;

}

/**
 * This Method will fetch the customerDetails with customerId.
 *
 * @param customerId the customer id
 * @return the customer details by ID
 */
@GetMapping("/customerDetails/{customerId}")
@Consumes("application/json")
@Produces("application/json")
@ApiOperation(value = "Get All Customer Dtails  based on input Customer Id.", response = CustomerDetailsResponse.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 400, message = "Fields are with validation errors"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Error occurred while deleting File") })
public CustomerDetailsResponse getCustomerDetailsByID(@RequestParam  int customerId)
	 {

	return applicationService.getCustomerDetails(customerId);


	
}

/**
 * The method to Excel customers report.
 *
 * @return the customer details response
 * @throws IOException Signals that an I/O exception has occurred.
 * @throws SecurityException 
 * @throws NoSuchFieldException 
 */
@GetMapping(value = "/download/Report")
@ApiOperation(value = "Generate Customer Dtails Report based on report Type", response = CustomerDetailsResponse.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 400, message = "Fields are with validation errors"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Error occurred while deleting File") })
public CustomerDetailsResponse getReport(@NotNull @RequestParam  int reportId,@RequestParam String reportName) throws IOException, NoSuchFieldException, SecurityException {
	
	return applicationService.getCustomersReport(reportId,reportName);	
}	



@GetMapping(value = "/download/customersDetailsReport")
@ApiOperation(value = "Generate Customer Dtails Report based on report Type", response = ReportGenerationResponse.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 400, message = "Fields are with validation errors"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Error occurred while deleting File") })
public ReportGenerationResponse getcustomerDetailsReport(@NotNull @RequestParam  int reportType) 
{
	
	return applicationService.getcustomerDetailsReport(reportType);	
	
}	



/**
 * The method to Reload cache.
 *
 * @param cacheName the cache name
 * @return true, if successful
 */
@ApiOperation(value = "Clear the Cache ")
@GetMapping("/clearCache")
@Consumes("application/json")
@Produces("application/json")
public boolean reloadCache(@RequestParam(value = "cacheName") String cacheName)  {
	
	boolean result=false;
	
	IMap<Object, Object> myCache = hazelConfig.getCacheDetails(cacheName);
	if(myCache!=null) {
		myCache.destroy();
		result=true;
	}


    return result;
      
	}	

	
}
