package tn.com.healthcare.web.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

@XmlRootElement
public class PatientDTO extends AbstractHealthcareDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lastName = StringUtils.EMPTY;

	private String firstName = StringUtils.EMPTY;

	private long identityCardNumber;

	private int bedNumber;

	private byte[] photo;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(long identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

}
