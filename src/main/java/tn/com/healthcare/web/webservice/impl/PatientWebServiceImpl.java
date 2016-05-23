package tn.com.healthcare.web.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.com.healthcare.core.model.Doctor;
import tn.com.healthcare.core.model.Patient;
import tn.com.healthcare.core.service.PatientService;
import tn.com.healthcare.web.webservice.PatientWebService;
import tn.com.healthcare.web.webservice.dto.DoctorDTO;
import tn.com.healthcare.web.webservice.dto.PatientDTO;

@Service("patientWebService")
@Path("/data/patient")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON)
public class PatientWebServiceImpl extends
		AbstractHealthcareWebService<Patient, Long, PatientDTO> implements
		PatientWebService {

	private PatientService patientService;

	@Autowired
	public PatientWebServiceImpl(PatientService patientService) {
		super(patientService);
		this.patientService = patientService;
	}

	@GET
	@Path("/save-measure")
	public String saveMeasure() {
		return "aaaa";

	}

	@GET
	@Path("/search-patients/{id}/{name}")
	public List<PatientDTO> searchById(@PathParam("id") long id,
			@PathParam("name") String name) {
		List<Patient> patients = patientService.searchById(id, name);
		List<PatientDTO> patientsDto = new ArrayList<PatientDTO>();

		for (Patient patient : patients) {
			PatientDTO dto = new PatientDTO();
			BeanUtils.copyProperties(patient, dto);
			patientsDto.add(dto);
		}

		return patientsDto;
	}

	/*
	 * for (T source : service.findAll()) { DTO target = getInstanceOfDTO();
	 * BeanUtils.copyProperties(source, target); results.add(target); } return
	 * results;
	 */

	@GET
	@Path("/find-mobileNumber/{id}")
	public DoctorDTO searchMobileNumber(@PathParam("id") long id) {
		Doctor doctor = patientService.searchMobileNumber(id);
		DoctorDTO dto = new DoctorDTO();
		if (doctor != null) {
			BeanUtils.copyProperties(doctor, dto);
			dto.setUserType("Doctor");
		}
		return dto;
	}

}
