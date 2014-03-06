package com.eventhorizon.jarvis.service;

import java.io.Serializable;
import java.util.List;

import com.eventhorizon.jarvis.entity.AbstractEntity;

/**
 * Interface comum a todos os servicos
 * 
 * @author iuriandreazza
 *
 * @param <T>
 * @param <K>
 */
public interface IService <T extends AbstractEntity<K>, K extends Serializable> {

    /**
     * Find All (List All Elements)
     * Slow Method, not to use often
     *
     * @return
     */
    List<T> findAll();
	T findById(K id);
    List<T> find(T entity);
    T save(T entity);
    void delete(T entity);
    T merge(T entity);
    void refresh(T entity);
	
}
