package com.beeva.MODEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Cliente {

	private String nombre;	
	private String apellido;
	
	@Autowired
	@Qualifier("cuentaBean")
	private Cuenta cuenta;
	
	private int idCliente;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido
				+ ", cuenta=" + cuenta.getTipoDeCuenta() +" con balance "+cuenta.getBalance() +", idCliente=" + idCliente + "]";
	}
	
	
	
}
