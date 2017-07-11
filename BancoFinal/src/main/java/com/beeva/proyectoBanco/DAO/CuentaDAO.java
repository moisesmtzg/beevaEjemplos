package com.beeva.proyectoBanco.DAO;

public abstract class CuentaDAO {
	
	public abstract boolean deposito(double cantidad,int idCliente);
	public abstract boolean retiro(double cantidad,int idCliente);
	
}
