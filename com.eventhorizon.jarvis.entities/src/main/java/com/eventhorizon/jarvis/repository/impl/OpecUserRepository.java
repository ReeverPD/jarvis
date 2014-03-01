package com.eventhorizon.jarvis.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.enuns.SimNao;
import com.eventhorizon.jarvis.repository.IOpecUserRepository;

@SuppressWarnings("unchecked")
@Repository
public class OpecUserRepository extends AbstractRepository<CMSUser, Long>
		implements IOpecUserRepository {

	@Override
	public CMSUser findByUsernamePassword(String username, String password) {
		
		Query query = this.getEntityManager().createQuery(    
				"SELECT u "
				+ "FROM CMSUser AS u "
				+ "WHERE u.username = :username "
				+ "	and u.password = :password "
				+ "	and u.ativo = :atv"
				);
		
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("atv", SimNao.S);
		List<CMSUser> lst = query.getResultList();

		if (lst.isEmpty()) {
			return null;
		}

		return lst.get(0);
	}

	@Override
	public CMSUser findByUsername(String username) {
		Query query = this.getEntityManager().createQuery(
				"SELECT u FROM CMSUser AS u WHERE u.username = :username ");
		query.setParameter("username", username);
		List<CMSUser> lst = query.getResultList();

		if (lst.isEmpty()) {
			return null;
		}

		return lst.get(0);
	}

	@Override
	public CMSUser findUserByToken(String token) {
		Query query = this.getEntityManager().createQuery(
				"SELECT u FROM CMSUser AS u WHERE u.token = :tk ");
		query.setParameter("tk", token);
		List<CMSUser> lst = query.getResultList();

		if (lst.isEmpty()) {
			return null;
		}

		return lst.get(0);
	}

}
