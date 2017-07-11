package com.beeva.proyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.TipoCuentaDAO;
import com.beeva.proyectoBanco.models.Tipocuenta;

@Repository
public class TipoCuentaDAOImplementacion extends TipoCuentaDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Tipocuenta getTipoCuenta(int idTipoCuenta) {
		return em.find(Tipocuenta.class, idTipoCuenta);
	}

}
