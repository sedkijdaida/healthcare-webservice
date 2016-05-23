package tn.com.healthcare.web.webservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.com.healthcare.core.model.Doctor;
import tn.com.healthcare.core.model.MaleNurse;
import tn.com.healthcare.core.model.User;
import tn.com.healthcare.core.service.UserService;
import tn.com.healthcare.web.webservice.UserWebService;
import tn.com.healthcare.web.webservice.dto.UserDTO;

@Service("userWebService")
@Path("/data/user")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON)
public class UserWebServiceImpl extends
		AbstractHealthcareWebService<User, Long, UserDTO> implements
		UserWebService {

	private UserService userService;

	@Autowired
	public UserWebServiceImpl(UserService userService) {
		super(userService);
		this.userService = userService;
	}

	@POST
	@Path("/check-connection/{login}/{password}")
	public UserDTO checkConnection(@PathParam("login") String login,
			@PathParam("password") String password) {
		User user = userService.checkConnection(login, password);
		UserDTO dto = new UserDTO();
		if (user != null) {
			BeanUtils.copyProperties(user, dto);
			if (user instanceof Doctor)
				dto.setUserType("Doctor");
			if (user instanceof MaleNurse)
				dto.setUserType("MaleNurse");
		}
		return dto;
	}

	@GET
	@Path("/findd/{id}")
	public String findOnee(@PathParam("id") int id) {

		return "ssss";

	}

}
