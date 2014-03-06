package com.eventhorizon.jarvis.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eventhorizon.jarvis.entity.AbstractEntity;
import com.eventhorizon.jarvis.repository.IRepository;


/**
 * 
 * @author iuriandreazza
 */
@Service
public abstract class AbstractService <T extends AbstractEntity<K>, K extends Serializable> implements IService<T, K> {
	
	public abstract IRepository<T, K> getRepository();

    /**
     * Find All (List All Elements)
     * Slow Method, not to use often
     *
     * @return
     */
    @Override
    public List<T> findAll(){
        return this.getRepository().findAll();
    }

    @Override
    public T findById(K id) {
        return this.getRepository().getById(id);
    }

    @Override
    public List<T> find(T entity) {
        return this.find(entity);
    }

    @Override
    public T save(T entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getRepository().delete(entity);
    }

    @Override
    public T merge(T entity) {
        return this.getRepository().merge(entity);
    }

    @Override
    public void refresh(T entity) {
        this.getRepository().refresh(entity);
    }
	
}
