package com.beeva.proyectoBanco.implementacion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.ClienteDAO;
import com.beeva.proyectoBanco.DAO.CuentaDAO;
import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Cliente;
import com.beeva.proyectoBanco.models.Cuenta;

@Repository
public class CuentaDAOImplementacion extends CuentaDAO{

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean deposito(double cantidad,Cliente cliente,Cuenta cuenta) {
		boolean bandera = false;
		if(cliente.getIdcliente() == cuenta.getCliente().getIdcliente()){
			BigDecimal bd = cuenta.getBalance();
			double balance = bd.doubleValue();
			double newBalance = balance+cantidad;
			BigDecimal b = new BigDecimal(newBalance, MathContext.DECIMAL64);
			cuenta.setBalance(b);
			if(em.merge(cuenta) == null){
				bandera = false;
			}else{
				bandera = true;
			}
		}else{
			bandera = false;
		}
		return bandera;
	}

	@Override
	@Transactional
	public boolean retiro(double cantidad,Cliente cliente,Cuenta cuenta) {
		boolean bandera = false;
		if(cuenta.getCliente().getIdcliente() == cliente.getIdcliente() ){
			Date now= new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
			String dia = dateFormat.format(now).toString();
			if(dia.equals("Saturday") || dia.equals("Sunday")){
				bandera = false;
			}else{
				if(cuenta.getTipocuenta().getIdtipocuenta() == 1){
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
				}else if(cuenta.getTipocuenta().getIdtipocuenta() == 2){
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
	public Cuenta agregarCuenta(Cuenta c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Cuenta> getTodasCuentas() {
		Query query = em.createNativeQuery("SELECT * FROM cuenta;",Cuenta.class);
		List<Cuenta> listaCuentas = query.getResultList();
		return listaCuentas;
	}

}
