package com.pos.base.service;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Generic Service Interface.
 * 
 * @author Kaushal Parikh
 *
 * @param <T>
 * @param <ID>
 */
public interface IGenericeService<T, ID extends Serializable> {

	/**
	 * Saves a given entity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 * 
	 * @param entity
	 *            entity
	 * @return entity
	 */
	public <E extends T> E save(E entity);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @param entity
	 *            entity
	 * @return entity
	 */
	public <E extends T> E saveAndFlush(E entity);

	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 *            the entities to set
	 * @return list of entities
	 */
	public <E extends T> List<E> save(Iterable<E> entities);

	/**
	 * This method is responsible for delete entity by id.
	 * 
	 * @param id
	 *            id
	 */
	public void delete(ID id);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 *            entity
	 */
	public void delete(T entity);

	/**
	 * Deletes all entities managed by the repository.
	 */
	public void deleteAll();

	/**
	 * Deletes all entites in a batch call.
	 */
	public void deleteAllInBatch();

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id
	 *            the id to set
	 * @return Boolean
	 */

	public Boolean exists(ID id);

	/**
	 * Returns all instances of the type.
	 * 
	 * @return list of entity
	 */
	public List<T> findAll();

	/**
	 * This method is responsible for find list of entity by given list of
	 * ids.Returns all instances of the type with the given IDs.
	 * 
	 * @param ids
	 *            the ids to set
	 * @return list of entity
	 */
	public List<T> findAll(Collection<ID> ids);

	/**
	 * Returns a Page of entities meeting the paging restriction provided in the
	 * Pageable object.
	 * 
	 * @param pageable
	 *            the pagable to set
	 * @return list of entity
	 */
	public Page<T> findAll(Pageable pageable);

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id
	 *            the id to set
	 * 
	 * @return entity
	 */
	public T findOne(ID id);

	/**
	 * Flushes all pending changes to the database.
	 */
	public void flush();

}
