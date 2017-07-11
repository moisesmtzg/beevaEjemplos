package com.beeva.implementacion;

import com.beeva.MODEL.Cuenta;
import com.beeva.dao.store.CuentaArray;
import com.beeva.interfaces.CuentaInterface;

public class CuentaAhorroDAOImplementation implements CuentaInterface{

	public CuentaArray cuentas = new CuentaArray();
	
	public CuentaAhorroDAOImplementation(Cuenta cuenta){
		cuentas.listaCuentas.add(cuenta);
	}
	
	public double getSaldo(Cuenta cuenta) {
		
		double balance =0.0;
		for(Cuenta cuentaArreglo : cuentas.listaCuentas){
			if(cuentaArreglo == cuenta){
				balance = cuentaArreglo.getBalance();
			}
		}
		return balance;
	}

	public boolean deposito(Cuenta cuenta,double cantidad) {
		boolean bandera = false;;
		double balance = 0.0;
		for(Cuenta cuentaList : cuentas.listaCuentas){
			if(cuentaList == cuenta){
				balance =cuentaList.getBalance();
				cuentaList.setBalance(balance+ cantidad);
				bandera =  true;
			}
		}
		return bandera;
	}

	public boolean retiro(Cuenta cuenta,double cantidad) {
		boolean bandera = false;;
		double balance = 0.0;
		for(Cuenta cuentaList : cuentas.listaCuentas){
			if(cuentaList == cuenta){
				balance =cuentaList.getBalance();
				if(balance <5000){
					cuentaList.setBalance(balance -cantidad);
					bandera = true;
				}
			}
		}
		return bandera;
	}

	public String toString(Cuenta cuenta) {
		String res ="";
		res+= "cuenta de ahorro con "+cuenta.getBalance();
		return res;
	}
	
	

}
