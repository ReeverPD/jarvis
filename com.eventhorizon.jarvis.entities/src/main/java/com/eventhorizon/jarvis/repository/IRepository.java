package com.eventhorizon.jarvis.repository;

import com.eventhorizon.jarvis.entities.AbstractEntity;


/**
* The commom interface for creating the repositories
*
* @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
*/
public interface IRepository <T extends AbstractEntity<K>, K extends Object> {

	/**
	 * Refresh the entitie
	 * @param entity
	 */
	void refresh(T entity);
	
	/**
	 * Merge entitie with database record, only update the altered fieds
	 * 
	 * @param entity
	 * @return
	 */
    T merge(T entity);
    
    /**
     * Save the entitie to the datastream
     * @param entity
     * @return
     */
    T save(T entity);
    
    /**
     * remove the entitie from the Manager
     * @param entity
     * @return
     */
    Boolean delete(T entity);    
    
    /**
     * return one entitie by it`s ID
     * @param id
     * @return
     */
    T getById(K id);
	
}
