package com.beeva.jpa.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.jpa.dao.UserDAO;
import com.beeva.jpa.model.User;

@Repository
public class UserImplementation extends UserDAO{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public User saveUser(User u) {
		em.persist(u);
		return u;
	}

	@Override
	public User getUser(int idUser) {
		User u = em.find(User.class, idUser);
		return u;
	}
	
	@Transactional
	@Override
	public void deleteUser(int idUser){
		User user = getUser(idUser);
		em.remove(user);
	}

}
