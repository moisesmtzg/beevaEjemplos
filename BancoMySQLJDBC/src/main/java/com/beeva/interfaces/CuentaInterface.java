package com.beeva.interfaces;

import com.beeva.MODEL.Cuenta;

public interface CuentaInterface {

	public boolean deposito(Cuenta cuenta,double cantidad);
	public boolean retiro(Cuenta cuenta,double cantidad);
	public String toString(Cuenta cuenta);
}
