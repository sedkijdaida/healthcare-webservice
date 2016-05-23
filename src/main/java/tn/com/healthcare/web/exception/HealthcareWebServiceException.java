package tn.com.healthcare.web.exception;

import javax.ws.rs.WebApplicationException;

/**
 * The JAX-RS API introduced the WebApplicationException runtime exception to
 * provide an easy way for resource methods to create exceptions that are
 * appropriate for RESTful clients to consume. WebApplicationException
 * exceptions can include a Response object that defines the entity body to
 * return to the originator of the request. It also provides a mechanism for
 * specifying the HTTP status code to be returned to the client if no entity
 * body is provided.
 * 
 */
public class HealthcareWebServiceException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public HealthcareWebServiceException() {
	}

	public HealthcareWebServiceException(Exception e) {
		super(e);
	}

}
