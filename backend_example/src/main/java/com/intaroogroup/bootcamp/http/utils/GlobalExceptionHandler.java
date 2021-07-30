/**
 * 
 */
package com.intaroogroup.bootcamp.http.utils;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.fluentd.logger.FluentLogger;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author anitamarsafira 
 *
 */
public class GlobalExceptionHandler {
	  public static final Response<Object> ChekingExceptionGlobal(String applicatioName, HttpServletResponse httpServletResponse, Exception e){
	        //fluentReport(applicatioName,e);
	        Throwable t = ExceptionUtils.getRootCause(e);
	        List<String> specificationError = new ArrayList<>();
	        specificationError.add(t.getStackTrace()[0].getClassName());
	        specificationError.add(t.getStackTrace()[0].getMethodName());

	        if(t instanceof ResourceNotFoundException){
	            return Response.statusError(httpServletResponse, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), specificationError);
	        }
	        else if(t instanceof JsonProcessingException){
	            return Response.statusError(httpServletResponse, HttpStatus.BAD_REQUEST, e.getMessage(), specificationError);
	        }

	        return Response.statusError(httpServletResponse, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), specificationError);

	    }
}
