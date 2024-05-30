package com.pos.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.pos.base.repository.GenericRepository;
import com.pos.base.service.IGenericeService;

/**
 * This is Generic Class for crud operation for all entity.
 * 
 * @author Kaushal Parikh
 *
 * @param <T>
 * @param <ID>
 */
@Component
public abstract class AGenericsService<T, ID extends Serializable> implements IGenericeService<T, ID> {

	/**
	 * Generic Logger for services
	 */
	protected Logger logger = LoggerFactory.getLogger(getServiceClass());

	/**
	 * This method will be overridden by sub-class and provides correponding JPA
	 * repository and will be used to perform database operations.
	 * 
	 * @return GenericRepository.
	 */
	public abstract GenericRepository<T, ID> getGenericRepository();

	/**
	 * Saves a given entity. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 * 
	 * @param entity entity
	 * @return entity
	 */
	@Override
	public <S extends T> S save(S entity) {
		return getGenericRepository().save(entity);
	}

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @param entity entity
	 * @return entity
	 */
	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return getGenericRepository().saveAndFlush(entity);
	}

	/**
	 * Saves all given entities.
	 * 
	 * @param entities the entities to set
	 * @return list of entities
	 */
	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return getGenericRepository().saveAll(entities);
	}

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id id
	 */
	@Override
	public void delete(ID id) {
		getGenericRepository().deleteById(id);
	}

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity entity
	 */
	@Override
	public void delete(T entity) {
		getGenericRepository().delete(entity);
	}

	/**
	 * Deletes all entities managed by the repository.
	 */
	@Override
	public void deleteAll() {
		getGenericRepository().deleteAll();
	}

	/**
	 * Deletes all entites in a batch call.
	 */
	@Override
	public void deleteAllInBatch() {
		getGenericRepository().deleteAllInBatch();
	}

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id the id to set
	 * @return Boolean
	 */

	@Override
	public Boolean exists(ID id) {
		return getGenericRepository().existsById(id);
	}

	/**
	 * Returns all instances of the type.
	 * 
	 * @return list of entity
	 */
	@Override
	public List<T> findAll() {
		return getGenericRepository().findAll();
	}

	/**
	 * This method is responsible for find list of entity by given list of
	 * ids.Returns all instances of the type with the given IDs.
	 * 
	 * @param ids the ids to set
	 * @return list of entity
	 */
	@Override
	public List<T> findAll(Collection<ID> ids) {
		return getGenericRepository().findAllById(ids);
	}

	/**
	 * Returns a Page of entities meeting the paging restriction provided in the
	 * Pageable object.
	 * 
	 * @param pageable the pagable to set
	 * @return list of entity
	 */
	@Override
	public Page<T> findAll(Pageable pageable) {
		return getGenericRepository().findAll(pageable);
	}

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id the id to set
	 * 
	 * @return entity
	 */
	@Override
	public T findOne(ID id) {
		return getGenericRepository().findById(id).orElse(null);
	}

	/**
	 * Flushes all pending changes to the database.
	 */
	@Override
	public void flush() {
		getGenericRepository().flush();
	}

	/**
	 * abstract method for get service class name.
	 * 
	 * @return
	 */
	public abstract Class<?> getServiceClass();

}
