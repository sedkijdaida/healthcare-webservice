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

import tn.com.healthcare.core.model.Measure;
import tn.com.healthcare.core.service.MeasureService;
import tn.com.healthcare.core.service.PatientService;
import tn.com.healthcare.web.webservice.MeasureWebService;
import tn.com.healthcare.web.webservice.dto.MeasureDTO;

@Service("measureWebService")
@Path("/data/measure")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON)
public class MeasureWebServiceImpl extends
		AbstractHealthcareWebService<Measure, Long, MeasureDTO> implements
		MeasureWebService {

	private MeasureService measureService;

	@Autowired
	private PatientService patientService;

	@Autowired
	public MeasureWebServiceImpl(MeasureService measureService) {
		super(measureService);
		this.measureService = measureService;
	}

	@GET
	@Path("/find-sort/{lastName}")
	public List<MeasureDTO> searchMeasure(@PathParam("lastName") String lastName) {

		List<Measure> measures = measureService.searchMeasure(lastName);
		List<MeasureDTO> measuresDto = new ArrayList<MeasureDTO>();

		for (Measure measure : measures) {
			MeasureDTO dto = new MeasureDTO();
			BeanUtils.copyProperties(measure, dto);
			measuresDto.add(dto);
		}

		return measuresDto;
	}

	@Override
	public Measure saveAndFlush(MeasureDTO entityDto) {
		Measure target = new Measure();
		BeanUtils.copyProperties(entityDto, target);
		return measureService.updatePatientMeasure(target,
				entityDto.getPatientId(), entityDto.getMaleNurseId());

	}
}
