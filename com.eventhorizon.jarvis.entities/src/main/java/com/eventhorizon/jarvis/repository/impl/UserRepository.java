package com.eventhorizon.jarvis.repository.impl;

import org.springframework.stereotype.Repository;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.repository.IUserRepository;

@Repository
public class UserRepository extends AbstractRepository<CMSUser, Long> implements IUserRepository {

	
	@Override
	public CMSUser findByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CMSUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CMSUser findUserByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
