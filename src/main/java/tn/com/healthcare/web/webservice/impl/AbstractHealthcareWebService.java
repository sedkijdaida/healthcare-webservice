package tn.com.healthcare.web.webservice.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.BeanUtils;

import tn.com.healthcare.core.model.AbstractHealthcareEntity;
import tn.com.healthcare.core.service.HealthcareEntityService;
import tn.com.healthcare.web.exception.HealthcareWebServiceException;
import tn.com.healthcare.web.webservice.HealthcareWebService;
import tn.com.healthcare.web.webservice.dto.AbstractHealthcareDTO;

public abstract class AbstractHealthcareWebService<T extends AbstractHealthcareEntity, ID extends Serializable, DTO extends AbstractHealthcareDTO>
		implements HealthcareWebService<T, ID, DTO> {

	private HealthcareEntityService<T, ID> service;

	private Class<DTO> dtoClass;

	private Class<T> entityClass;

	public AbstractHealthcareWebService(HealthcareEntityService<T, ID> service) {
		this.service = service;
		ParameterizedType superClass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.dtoClass = (Class<DTO>) superClass.getActualTypeArguments()[2];
		this.entityClass = (Class<T>) superClass.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tn.rnu.isitcom.medical.webservice.MedicalWebService#findAll()
	 */
	@GET
	@Path("/find-all")
	public List<DTO> findAll() {
		List<DTO> results = new ArrayList<DTO>();
		for (T source : service.findAll()) {
			DTO target = getInstanceOfDTO();
			BeanUtils.copyProperties(source, target);
			results.add(target);
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tn.rnu.isitcom.medical.webservice.MedicalWebService#saveAndFlush()
	 */
	@POST
	@Path("/save-flush")
	public T saveAndFlush(DTO entityDto) {
		T target = getInstanceOfEntity();
		BeanUtils.copyProperties(entityDto, target);
		return service.saveAndFlush(target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tn.rnu.isitcom.medical.webservice.MedicalWebService#findOne()
	 */
	@GET
	@Path("/find/{id}")
	public DTO findOne(@PathParam("id") ID id) {
		T source = service.findOne(id);
		DTO target = getInstanceOfDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tn.rnu.isitcom.medical.webservice.MedicalWebService#delete(id)
	 */
	@GET
	@Path("/delete/{id}")
	public void delete(@PathParam("id") ID id) {
		service.delete(id);
	}

	/**
	 * Creates a DTO instance.
	 * 
	 * @return a DTO object.
	 */
	private DTO getInstanceOfDTO() {
		try {
			return dtoClass.newInstance();
		} catch (InstantiationException e) {
			throw new HealthcareWebServiceException(e);
		} catch (IllegalAccessException e) {
			throw new HealthcareWebServiceException(e);
		}
	}

	/**
	 * Creates an entity instance.
	 * 
	 * @return an entity object.
	 */
	private T getInstanceOfEntity() {
		try {
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			throw new HealthcareWebServiceException(e);
		} catch (IllegalAccessException e) {
			throw new HealthcareWebServiceException(e);
		}
	}
}
