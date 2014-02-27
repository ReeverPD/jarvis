package com.eventhorizon.jarvis.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import com.eventhorizon.jarvis.entity.AbstractEntity;
import com.eventhorizon.jarvis.repository.IRepository;

/**
 * 
 * @author iuriandreazza
 *
 * @param <T>
 * @param <K>
 */
@SuppressWarnings({ "unchecked" , "restriction" })
public abstract class AbstractRepository<T extends AbstractEntity<K>, K extends Object> implements IRepository<T, K> {

	private Class<AbstractEntity<K>> type;
	
    @Getter
    private final Logger _logger = LoggerFactory.getLogger(AbstractRepository.class);
    
    @Getter(value=AccessLevel.PROTECTED)
    protected EntityManager entityManager;

    /**
     * Contructor
     */
    public AbstractRepository(){
        if(getClass().getGenericSuperclass() instanceof ParameterizedTypeImpl){
            type = (Class<AbstractEntity<K>>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }
    
    /**
     * Contructor
     * @param persistenceClass
     */
    public AbstractRepository(Class<AbstractEntity<K>> persistenceClass){
        type = persistenceClass;
    }
    
    /**
     * Return the entityManager
     * 
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<T> findAll(){
    	Query qry = this.getEntityManager().createNamedQuery(type.getName()+".findAll");
    	return qry.getResultList();
    }
	
	@Transactional
    @Override
    public T getById(K id) {
        return (T)this.getEntityManager().find(type, id);
    }

    @Transactional
    @Override
    public T save(T entity) {
        this.getEntityManager().persist(entity);
        this.getEntityManager().flush();
        return entity;
    }

    @Transactional
    @Override
    public Boolean delete(T entity) {
        try{
            this.getEntityManager().remove(entity);
            return true;
        }catch(Exception ex){
            _logger.error("Erro ao tentar remover entidade", ex);
            return false;
        }
    }

    @Transactional
    @Override
    public T merge(T entity) {
        return (T)this.getEntityManager().merge(entity);
    }
    
    
    @Override
    public void refresh(T entity) {
        this.getEntityManager().refresh(entity);
    }

}
