package tn.com.healthcare.web.webservice;

import tn.com.healthcare.core.model.PatientReport;
import tn.com.healthcare.web.webservice.dto.PatientReportDTO;

public interface PatientReportWebService extends
		HealthcareWebService<PatientReport, Long, PatientReportDTO> {

}
