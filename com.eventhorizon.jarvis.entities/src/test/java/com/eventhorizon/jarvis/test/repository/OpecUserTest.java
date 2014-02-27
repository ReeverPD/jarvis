package com.eventhorizon.jarvis.test.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*; 

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.enuns.SimNao;
import com.eventhorizon.jarvis.repository.IOpecUserRepository;
import com.eventhorizon.jarvis.repository.impl.OpecUserRepository;
import com.eventhorizon.jarvis.test.JarvisBaseTest;


/**
 * Classe de teste do Repositorio da OPEC que controla o Usuário
 * 
 * 
 * @author iuriandreazza
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configurable(autowire = Autowire.BY_NAME)
@ContextConfiguration(locations = { "classpath:applicationContext-jarvis-entities.xml" })
@ActiveProfiles(profiles = {"enterpriseTest"})
@TransactionConfiguration(defaultRollback = true)
@Transactional(propagation=Propagation.REQUIRED)
public class OpecUserTest{
	
	@Autowired
	private OpecUserRepository opecUserRepository;
	
	private CMSUser userTestAtivo;
	private CMSUser userTestInativo;
	
	@Before
	public void setUp() throws Exception {
		
		userTestAtivo = new CMSUser();
		userTestAtivo.setUsername("userTeste1");
		userTestAtivo.setPassword("123");
		userTestAtivo.setAtivo(SimNao.SIM);
		userTestAtivo.setPicture("Pic1");
		userTestAtivo = opecUserRepository.save(userTestAtivo);
		userTestAtivo.setToken(userTestAtivo.getTokenHash());
		userTestAtivo = opecUserRepository.save(userTestAtivo);

		userTestInativo = new CMSUser();
		userTestInativo.setUsername("userTeste2");
		userTestInativo.setPassword("1234");
		userTestInativo.setAtivo(SimNao.NAO);
		userTestInativo.setPicture("Pic2");
		userTestInativo = opecUserRepository.save(userTestInativo);
		userTestInativo.setToken(userTestInativo.getTokenHash());
		userTestInativo = opecUserRepository.save(userTestInativo);

	}

	@After
	public void tearDown() throws Exception {
		opecUserRepository.delete(userTestAtivo);
		opecUserRepository.delete(userTestInativo);
		
	}

	/**
	 * Valida se os métodos de find do Usuario por username e password estão
	 * conforme as regras.
	 * 
	 */
	@Test
	public void testFindByUsernamePassword() {
		// Deve achar usuario
		assertNotNull(opecUserRepository.findByUsernamePassword(userTestAtivo.getUsername(), userTestAtivo.getPassword()));
		// Deve não achar um usuário inativo
		assertNull(opecUserRepository.findByUsernamePassword(userTestInativo.getUsername(), userTestInativo.getPassword()));
		// Deve não achar um usuario inexistente
		assertNull(opecUserRepository.findByUsernamePassword("userBlabla","BLA"));
	}

	@Test
	public void testFindByUsername() {
		// Deve achar usuario Ativo
		assertNotNull(opecUserRepository.findByUsername(userTestAtivo.getUsername()));
		// Deve achar usuario inativo
		assertNotNull(opecUserRepository.findByUsername(userTestInativo.getUsername()));
	}

	@Test
	public void testFindUserByToken() {
		// Deve achar usuario Ativo
		assertNotNull(opecUserRepository.findUserByToken(userTestAtivo.getTokenHash()));
		// Deve achar usuario inativo
		assertNotNull(opecUserRepository.findUserByToken(userTestInativo.getTokenHash()));
	}

}
