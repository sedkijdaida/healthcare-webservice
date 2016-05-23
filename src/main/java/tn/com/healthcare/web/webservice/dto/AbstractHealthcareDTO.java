package tn.com.healthcare.web.webservice.dto;

import java.io.Serializable;

public abstract class AbstractHealthcareDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
