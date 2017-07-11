package com.beeva.factory;

import com.beeva.MODEL.Cuenta;
import com.beeva.implementacion.CuentaAhorroDAOImplementation;
import com.beeva.implementacion.CuentaChequesDAOImplementation;
import com.beeva.interfaces.CuentaInterface;

public class CuentaFactory {


	public CuentaInterface cuentaImpl(Cuenta cuenta){
		CuentaInterface cuentaDAO = null;
		if(cuenta.getTipoDeCuenta() == "cheques"){
			cuentaDAO = new CuentaChequesDAOImplementation(cuenta);
		}
		if(cuenta.getTipoDeCuenta() == "ahorro"){
			cuentaDAO = new CuentaAhorroDAOImplementation(cuenta);
		}
		return cuentaDAO;
	}
	
}
