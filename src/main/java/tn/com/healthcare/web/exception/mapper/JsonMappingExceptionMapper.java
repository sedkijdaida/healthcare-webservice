package tn.com.healthcare.web.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;

import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * In order to respond for these cases : - you may not want to catch all
 * possible exceptions and then create a WebApplicationException for them. - You
 * may also want to use custom exceptions that make working with your
 * application code easier.
 * 
 * The JAX-RS API allows you to implement a custom exception provider that
 * generates a Response object to send to a client. Custom exception providers
 * are created by implementing the ExceptionMapper interface. When registered
 * with the Apache CXF runtime, the custom provider will be used whenever an
 * exception of type E is thrown.The interface has a single method,
 * toResponse(), that takes the original exception as a parameter and returns a
 * Response object.
 * 
 * 
 */
@Provider
public class JsonMappingExceptionMapper implements
		ExceptionMapper<JsonMappingException> {

	/**
	 * The Response class has a protected constructor, so they cannot be
	 * instantiated directly. They are created using the ResponseBuilder class
	 * enclosed by the Response class. The ResponseBuilder class is a holder for
	 * all of the information that will be encapsulated in the response created
	 * from it. The ResponseBuilder class also has all of the methods
	 * responsible for setting HTTP header properties on the message.
	 * 
	 * @param jme
	 *            : the exception to map to a response.
	 * @return a response mapped from the supplied exception.
	 */
	public Response toResponse(JsonMappingException jme) {
		ResponseBuilderImpl builder = new ResponseBuilderImpl();
		builder.type(MediaType.APPLICATION_JSON);
		builder.status(Response.Status.OK);
		String message = jme.getMessage();
		if (StringUtils.isBlank(message)) {
			message = "SERVER_ERROR";
		}
		builder.entity("{error : '" + message + "'}");
		return builder.build();
	}
}
