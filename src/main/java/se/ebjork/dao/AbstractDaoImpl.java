package se.ebjork.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract DAO to be extended by specific entity DAOs.
 *
 * @param <T> Entity type
 * @param <PK> Private key type
 */
public abstract class AbstractDaoImpl<T extends Serializable, PK extends Serializable> implements AbstractDao<T, PK> {

    @PersistenceContext
    private EntityManager em;

    private final Class<T> entityType;

    /**
     * @param type Entity type
     */
    public AbstractDaoImpl(final Class<T> type) {
        this.entityType = type;
    }

    /**
     * @return Entity manager
     */
    public final EntityManager getEm() {
        return em;
    }

    /**
     * Returns entity type.
     * @return Entity type
     */
    public final Class<T> getType() {
        return entityType;
    }

    @Override
    public final T find(final PK id) {
        return em.find(entityType, id);
    }

    @Override
    public final List<T> findAll() {
        return em.createQuery("from " + entityType.getName(), entityType).getResultList();
    }

    @Override
    public final void save(final T entity) {
        em.persist(entity);
    }

    @Override
    public final void update(final T entity) {
        em.merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        em.remove(entity);
    }

    @Override
    public final void deleteById(final PK id) {
        em.remove(em.find(entityType, id));
    }

    @Override
    public final long count() {
        return (Long) em.createQuery("select count(*) from " + entityType.getName()).getSingleResult();
    }
}
