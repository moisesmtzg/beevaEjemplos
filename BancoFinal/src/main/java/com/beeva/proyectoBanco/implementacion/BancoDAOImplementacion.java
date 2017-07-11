package com.beeva.proyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.BancoDAO;
import com.beeva.proyectoBanco.models.Banco;

@Repository
public class BancoDAOImplementacion extends BancoDAO{

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Banco agregarBanco(Banco b) {
		em.persist(b);
		return b;
	}

	@Override
	public Banco obtenerBanco(int idBanco) {
		Banco b = em.find(Banco.class, idBanco);
		return b;
	}

	@Override
	public void eliminarBanco(int idBanco) {
		Banco b = obtenerBanco(idBanco);
		em.remove(b);
		
	}

}
