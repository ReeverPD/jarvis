package com.eventhorizon.jarvis.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the CMSUsers database table.
 * 
 */
@Entity
@Table(name="CMSUsers")
@NamedQuery(name="CMSUser.findAll", query="SELECT c FROM CMSUser c")
public class CMSUser extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = -8758681200474185698L;

	private Logger log = LoggerFactory.getLogger(CMSUser.class);
	
	@Getter @Setter
	private String ativo;

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String picture;
	
	@Getter @Setter
	private String username;

	
	public String getToken(){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(this.getId().toString().getBytes());
			return new String(md.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error("Erro ao criar algoritimo MD5");
		}
		return null;
	}
	
}