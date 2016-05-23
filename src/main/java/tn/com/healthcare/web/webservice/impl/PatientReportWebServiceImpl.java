package tn.com.healthcare.web.webservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.com.healthcare.core.model.PatientReport;
import tn.com.healthcare.core.service.DoctorService;
import tn.com.healthcare.core.service.PatientReportService;
import tn.com.healthcare.web.webservice.PatientReportWebService;
import tn.com.healthcare.web.webservice.dto.PatientReportDTO;

@Service("patientReportWebService")
@Path("/data/patientReport")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON)
public class PatientReportWebServiceImpl extends
		AbstractHealthcareWebService<PatientReport, Long, PatientReportDTO>
		implements PatientReportWebService {

	private PatientReportService patientReportService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	public PatientReportWebServiceImpl(PatientReportService patientReportService) {
		super(patientReportService);
		this.patientReportService = patientReportService;
	}

	@Override
	public PatientReport saveAndFlush(PatientReportDTO entityDto) {
		PatientReport target = new PatientReport();
		BeanUtils.copyProperties(entityDto, target);
		return patientReportService.updatePatientReport(target,
				entityDto.getDoctorId());

	}

}
