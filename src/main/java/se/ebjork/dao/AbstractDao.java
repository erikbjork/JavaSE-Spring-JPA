package se.ebjork.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Basic DAO interface.
 *
 * @param <T> Entity type
 * @param <PK> Private key type
 */
public interface AbstractDao<T extends Serializable, PK extends Serializable> {

    /**
     * Find entity by ID.
     *
     * @param id ID
     * @return Matched entity
     */
    T find(PK id);

    /**
     * Find all entities of type T.
     *
     * @return List of entities
     */
    List<T> findAll();

    /**
     * Save entity.
     *
     * @param entity Entity to save
     */
    void save(T entity);

    /**
     * Update entity.
     *
     * @param entity Entity to update
     */
    void update(T entity);

    /**
     * Delete entity.
     *
     * @param entity Entity to delete
     */
    void delete(T entity);

    /**
     * Delete entity by ID.
     *
     * @param id ID
     */
    void deleteById(PK id);

    /**
     * Returns number of entities of type T.
     *
     * @return Number of entities
     */
    long count();

}
