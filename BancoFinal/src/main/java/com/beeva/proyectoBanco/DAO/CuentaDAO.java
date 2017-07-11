package com.beeva.proyectoBanco.DAO;

import com.beeva.proyectoBanco.models.Cuenta;

public abstract class CuentaDAO {
	
	public abstract boolean deposito(double cantidad,int idCliente,int idTipoCuenta);
	public abstract boolean retiro(double cantidad,int idCliente,int idTipoCuenta);
	public abstract void agregarCuenta(Cuenta c);
	
}
