/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.util;

import com.mea.bpm.constants.GeneralResponseCode;
import com.mea.bpm.constants.GeneralResponseDescription;
import com.mea.bpm.enums.MessageType;
import com.mea.bpm.request.BaseRequest;
import com.mea.bpm.response.BaseResponse;
import com.mea.bpm.response.Status;

import il.co.luemi.constants.AppDataConstants;

public class BaseRequestUtil {
	
	
	private BaseRequestUtil() {
		
	}
	
	/**
	 * This method will convert response to BaseResponse.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the base response
	 */
	public static BaseResponse convertBaseRequestToBaseResponse(BaseRequest request, BaseResponse response) {
		
		response.setRequestId(request.getUuid());
		response.setSessionId(request.getSessionId());
		Status status = new Status();
		status.setStatusCode(GeneralResponseCode.SUCCES_STATUS_CODE);
		status.setStatusDescription(GeneralResponseDescription.SUCCES_STATUS_DESC);
		status.setSeverity(MessageType.INFO.toString());
		status.setSystem(AppDataConstants.APP_SYSTEM);
		return response;
	}

}
