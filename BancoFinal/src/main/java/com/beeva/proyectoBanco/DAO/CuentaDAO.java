package com.beeva.proyectoBanco.DAO;

import java.util.List;

import com.beeva.proyectoBanco.models.Cliente;
import com.beeva.proyectoBanco.models.Cuenta;

public abstract class CuentaDAO {
	
	public abstract boolean deposito(double cantidad,Cliente cliente,Cuenta cuenta);
	public abstract boolean retiro(double cantidad,Cliente cliente,Cuenta cuenta);
	public abstract Cuenta agregarCuenta(Cuenta c);
	public abstract List<Cuenta> getTodasCuentas();
	
}
