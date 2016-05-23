package tn.com.healthcare.web.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

@XmlRootElement
public class UserDTO extends AbstractHealthcareDTO {

	private static final long serialVersionUID = 1L;

	private String firstName = StringUtils.EMPTY;

	private String lastName = StringUtils.EMPTY;

	private String userType = StringUtils.EMPTY;

	private String email = StringUtils.EMPTY;

	private int mobilePhoneNumber;

	/**
	 * @return the mobilePhoneNumber
	 */
	public int getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * @param mobilePhoneNumber
	 *            the mobilePhoneNumber to set
	 */
	public void setMobilePhoneNumber(int mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
