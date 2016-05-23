package tn.com.healthcare.web.webservice;

import java.util.List;

import tn.com.healthcare.core.model.Patient;
import tn.com.healthcare.web.webservice.dto.DoctorDTO;
import tn.com.healthcare.web.webservice.dto.PatientDTO;

public interface PatientWebService extends
		HealthcareWebService<Patient, Long, PatientDTO> {

	List<PatientDTO> searchById(long id, String name);

	DoctorDTO searchMobileNumber(long id);
}
