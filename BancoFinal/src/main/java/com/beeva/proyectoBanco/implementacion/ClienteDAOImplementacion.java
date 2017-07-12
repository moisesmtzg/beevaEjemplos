package com.beeva.proyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.ClienteDAO;
import com.beeva.proyectoBanco.models.Cliente;

@Repository
public class ClienteDAOImplementacion extends ClienteDAO{

	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	@Transactional
	public Cliente getCliente(int idCliente) {
		Cliente c = em.find(Cliente.class, idCliente);
		return c;
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente c) {
		em.persist(c);
		em.flush();
		return c;
	}

	@Override
	@Transactional
	public void eliminarCliente(int idCliente) {
		Cliente c  = getCliente(idCliente);
		em.remove(c);
	}

	@Override
	@Transactional
	public Cliente actualizarCliente(Cliente c) {
		em.merge(c);
		return c;
	}

}
