package tn.com.healthcare.web.webservice.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import tn.com.healthcare.web.webservice.utils.DateFormatterAdapter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement
public class MeasureDTO extends AbstractHealthcareDTO {

	private static final long serialVersionUID = 1L;

	private long temperatureValue;

	private long pressureValue;

	private long heartBeat;

	private long glucoseValue;

	private long pulseValue;

	@JsonSerialize(using = DateFormatterAdapter.class)
	private Date date;

	private long patientId;

	private long maleNurseId;

	/**
	 * @return the temperatureValue
	 */
	public long getTemperatureValue() {
		return temperatureValue;
	}

	/**
	 * @param temperatureValue
	 *            the temperatureValue to set
	 */
	public void setTemperatureValue(long temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	/**
	 * @return the pressureValue
	 */
	public long getPressureValue() {
		return pressureValue;
	}

	/**
	 * @param pressureValue
	 *            the pressureValue to set
	 */
	public void setPressureValue(long pressureValue) {
		this.pressureValue = pressureValue;
	}

	/**
	 * @return the heartBeat
	 */
	public long getHeartBeat() {
		return heartBeat;
	}

	/**
	 * @param heartBeat
	 *            the heartBeat to set
	 */
	public void setHeartBeat(long heartBeat) {
		this.heartBeat = heartBeat;
	}

	/**
	 * @return the glucoseValue
	 */
	public long getGlucoseValue() {
		return glucoseValue;
	}

	/**
	 * @param glucoseValue
	 *            the glucoseValue to set
	 */
	public void setGlucoseValue(long glucoseValue) {
		this.glucoseValue = glucoseValue;
	}

	/**
	 * @return the pulseValue
	 */
	public long getPulseValue() {
		return pulseValue;
	}

	/**
	 * @param pulseValue
	 *            the pulseValue to set
	 */
	public void setPulseValue(long pulseValue) {
		this.pulseValue = pulseValue;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the patientId
	 */
	public long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the maleNurseId
	 */
	public long getMaleNurseId() {
		return maleNurseId;
	}

	/**
	 * @param maleNurseId
	 *            the maleNurseId to set
	 */
	public void setMaleNurseId(long maleNurseId) {
		this.maleNurseId = maleNurseId;
	}

}
