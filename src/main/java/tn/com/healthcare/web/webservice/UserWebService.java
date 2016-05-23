package tn.com.healthcare.web.webservice;

import tn.com.healthcare.core.model.User;
import tn.com.healthcare.web.webservice.dto.UserDTO;

public interface UserWebService extends
		HealthcareWebService<User, Long, UserDTO> {
	UserDTO checkConnection(String login, String password);
}
