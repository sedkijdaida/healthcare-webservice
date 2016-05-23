package tn.com.healthcare.web.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;

import tn.com.healthcare.web.exception.HealthcareWebServiceException;

@Provider
public class HealthcareWebServiceExceptionMapper implements
		ExceptionMapper<HealthcareWebServiceException> {

	public Response toResponse(HealthcareWebServiceException exception) {
		ResponseBuilderImpl builder = new ResponseBuilderImpl();
		builder.type(MediaType.APPLICATION_JSON);
		builder.status(Response.Status.OK);
		String message = exception.getMessage();
		if (StringUtils.isBlank(message)) {
			message = "SERVER_ERROR";
		}
		builder.entity("{error : '" + message + "'}");
		return builder.build();
	}

}
