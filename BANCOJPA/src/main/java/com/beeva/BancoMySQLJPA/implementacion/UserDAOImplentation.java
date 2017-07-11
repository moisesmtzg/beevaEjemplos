package com.beeva.BancoMySQLJPA.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.BancoMySQLJPA.dao.UserDAO;
import com.beeva.models.User;

@Repository
public class UserDAOImplentation extends UserDAO{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	@Transactional
	public void save(User u) {
		em.persist(u);
	}

	public User getUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
