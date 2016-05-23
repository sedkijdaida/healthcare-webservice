package tn.com.healthcare.web.webservice;

import java.io.Serializable;
import java.util.List;

import tn.com.healthcare.core.model.AbstractHealthcareEntity;
import tn.com.healthcare.web.webservice.dto.AbstractHealthcareDTO;

public interface HealthcareWebService<T extends AbstractHealthcareEntity, ID extends Serializable, DTO extends AbstractHealthcareDTO> {

	/**
	 * Returns all entities.
	 * 
	 * @return all entities.
	 */
	List<DTO> findAll();

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	T saveAndFlush(DTO entity);

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException
	 *             if {@code id} is {@literal null}
	 */
	DTO findOne(ID id);

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @throws IllegalArgumentException
	 *             in case the given {@code id} is {@literal null}
	 */
	void delete(ID id);

}
