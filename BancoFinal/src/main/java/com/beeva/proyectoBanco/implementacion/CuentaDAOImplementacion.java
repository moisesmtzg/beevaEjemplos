package com.beeva.proyectoBanco.implementacion;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.ClienteDAO;
import com.beeva.proyectoBanco.DAO.CuentaDAO;
import com.beeva.proyectoBanco.models.Cliente;
import com.beeva.proyectoBanco.models.Cuenta;

@Repository
public class CuentaDAOImplementacion extends CuentaDAO{

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean deposito(double cantidad,int idCliente,int idTipoCuenta) {
		ClienteDAO cDAO = null;
		Cliente c =cDAO.getCliente(idCliente);
		List<Cuenta> listaCuentasCLiente = c.getCuentas();
		boolean bandera = false;
		for(Cuenta cuenta : listaCuentasCLiente){
			if(cuenta.getTipocuenta().getIdtipocuenta()== idTipoCuenta){
				Double cantidadCuenta = cuenta.getBalance().doubleValue();
				BigDecimal res = null;
				res.valueOf((cantidadCuenta+cantidad));
				cuenta.setBalance(res);
				if(em.merge(cuenta) == null){
					bandera = false;
				}else{
					bandera = true;
				}
			}
		}
		return bandera;
	}

	@Override
	@Transactional
	public boolean retiro(double cantidad,int idCliente,int idTipoCuenta) {
		ClienteDAO cDAO = null;
		Cliente c =cDAO.getCliente(idCliente);
		List<Cuenta> listaCuentasCLiente = c.getCuentas();
		boolean bandera = false;
		for(Cuenta cuenta : listaCuentasCLiente){
			if(cuenta.getTipocuenta().getIdtipocuenta() == idTipoCuenta){
				if(idTipoCuenta == 1){
					int diaSem = (int) (Math.random()*7);
					if(diaSem == 5 || diaSem ==6){
						bandera = false;
					}else{
						Double cantidadCuenta = cuenta.getBalance().doubleValue();
						if(cantidadCuenta < cantidad){
							bandera = false;
						}else{
							BigDecimal res = null;
							res.valueOf((cantidadCuenta-cantidad));
							cuenta.setBalance(res);
							em.merge(cuenta);
							bandera = true;
						}
					}
				}else if(idTipoCuenta == 2){
					Double cantidadCuenta = cuenta.getBalance().doubleValue();
					if(cantidadCuenta < cantidad){
						bandera = false;
					}else{
						if(cantidadCuenta>5000){
							BigDecimal res = null;
							res.valueOf((cantidadCuenta-cantidad));
							cuenta.setBalance(res);
							em.merge(cuenta);
							bandera = true;
						}else{
							bandera = false;
						}
					}
				}
			}
		}
		return bandera;
	}

	@Override
	@Transactional
	public void agregarCuenta(Cuenta c) {
		em.persist(c);
		
	}

}
