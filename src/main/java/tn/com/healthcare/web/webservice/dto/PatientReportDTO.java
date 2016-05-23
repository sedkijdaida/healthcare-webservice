package tn.com.healthcare.web.webservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientReportDTO extends ReportDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long doctorId;

	/**
	 * @return the doctorId
	 */
	public long getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

}
