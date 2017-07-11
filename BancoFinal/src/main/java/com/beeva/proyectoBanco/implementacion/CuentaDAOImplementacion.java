package com.beeva.proyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.CuentaDAO;

@Repository
public class CuentaDAOImplementacion extends CuentaDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean deposito(double cantidad,int idCliente) {
		
		return false;
	}

	@Override
	@Transactional
	public boolean retiro(double cantidad,int idCliente) {
		// TODO Auto-generated method stub
		return false;
	}

}
