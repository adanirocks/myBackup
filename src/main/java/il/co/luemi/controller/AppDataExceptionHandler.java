/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */

package il.co.luemi.controller;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mea.bpm.constants.FieldValidationErrorList;
import com.mea.bpm.constants.GeneralResponseCode;
import com.mea.bpm.constants.GeneralResponseDescription;
import com.mea.bpm.enums.MessageType;
import com.mea.bpm.resource.util.MessageUtils;
import com.mea.bpm.response.BaseResponse;
import com.mea.bpm.response.Status;

import il.co.luemi.constants.AppDataConstants;
import il.co.luemi.constants.AppDataThreadContext;
import il.co.luemi.exception.AppDataException;
import il.co.luemi.exception.AppDataResourceNotFoundException;
import il.co.luemi.exception.AppDataTransactionException;
import il.co.luemi.exception.AppDataValidationException;

/**
 * The Class AppDataExceptionHandler.
 *
 * @author TCS
 */
@ControllerAdvice
public class AppDataExceptionHandler {

	/**
	 * Handle constraint violation exception.
	 *
	 * @param e
	 *            the e
	 * @return the response entity
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<BaseResponse> handleConstraintViolationException(ConstraintViolationException e)
			{

		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.BAD_REQUEST_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.BAD_REQUEST_STATUS_DESC);
		FieldValidationErrorList fieldValidationErrorList = new FieldValidationErrorList(MessageType.ERROR);
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

		for (ConstraintViolation<?> violation : violations) {

			fieldValidationErrorList.addFieldError(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(),
					violation.getMessage(), violation.getMessage());

		}
		status.setSeverity(MessageType.ERROR.toString());// error
		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, null, fieldValidationErrorList), HttpStatus.BAD_REQUEST);

	}

	/**
	 * Handle validation error.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<BaseResponse> handleValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> errors = result.getFieldErrors();

		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.BAD_REQUEST_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.BAD_REQUEST_STATUS_DESC);
		FieldValidationErrorList fieldValidationErrorList = new FieldValidationErrorList(
				com.mea.bpm.enums.MessageType.ERROR);

		for (org.springframework.validation.FieldError fieldError : errors) {
			fieldValidationErrorList.addFieldError(fieldError.getField(), fieldError.getDefaultMessage(),
					fieldError.getCode());
		}
		status.setSeverity(MessageType.ERROR.toString());// error
		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, null, fieldValidationErrorList), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle app data validation exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(AppDataValidationException.class)
	public ResponseEntity<BaseResponse> handleAppDataValidationException(AppDataValidationException ex) {
		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.VALIDATION_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.VALIDATION_STATUS_DESC);
		status.setErrorCode(ex.getMessage());
		status.setErrorDescription(MessageUtils.getProperty(ex.getMessage()));
		status.setSeverity(MessageType.ERROR.toString());// error
		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, ex.getAdditionalStatusList(), null), HttpStatus.OK);
	}

	/**
	 * Handle app data resource not found exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(AppDataResourceNotFoundException.class)
	public ResponseEntity<BaseResponse> handleAppDataResourceNotFoundException(AppDataResourceNotFoundException ex) {
		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.RESOURCE_NOT_FOUND_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.RESOURCE_NOT_FOUND_STATUS_DESC);
		status.setErrorCode(ex.getMessage());
		status.setErrorDescription(MessageUtils.getProperty(ex.getMessage()));
		status.setSeverity(MessageType.ERROR.toString());// error

		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, ex.getAdditionalStatusList(), null), HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle app data transaction exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(AppDataTransactionException.class)
	public ResponseEntity<BaseResponse> handleAppDataTransactionException(AppDataTransactionException ex) {
		System.out.println("Inside ExcepTion Method");
		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.EXCEPTION_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.EXCEPTION_STATUS_DESC);
		status.setErrorCode(ex.getMessage());
		status.setErrorDescription(MessageUtils.getProperty(ex.getMessage()));
		status.setSeverity(MessageType.ERROR.toString());// error

		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, ex.getAdditionalStatusList(), null),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle Application data exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(AppDataException.class)
	public ResponseEntity<BaseResponse> handleAppDataException(AppDataException ex) {

		Status status = new Status();
		status.setSystem(AppDataConstants.APP_SYSTEM);
		status.setStatusCode(GeneralResponseCode.EXCEPTION_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.EXCEPTION_STATUS_DESC);
		status.setErrorCode(AppDataConstants.APP_RUN_TIME_EXCEPTION);
		status.setErrorDescription(MessageUtils.getProperty(AppDataConstants.APP_RUN_TIME_EXCEPTION));
		status.setSeverity(MessageType.ERROR.toString());// error

		return new ResponseEntity<>(new BaseResponse(AppDataThreadContext.getRequestId(),
				AppDataThreadContext.getSessionId(), status, null, null), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}