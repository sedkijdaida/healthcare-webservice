/**
 * 
 */
package tn.com.healthcare.web.webservice;

import java.util.List;

import tn.com.healthcare.core.model.Measure;
import tn.com.healthcare.web.webservice.dto.MeasureDTO;

/**
 * @author sedki Jdaida
 * 
 */
public interface MeasureWebService extends
		HealthcareWebService<Measure, Long, MeasureDTO> {
	List<MeasureDTO> searchMeasure(String lastName);

}
