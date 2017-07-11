package com.beeva.proyectoBanco.models;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tipocuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocuenta.findAll", query="SELECT t FROM Tipocuenta t")
public class Tipocuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipoCuenta;

	private String nombre;

	public Tipocuenta() {
	}

	public int getIdtipoCuenta() {
		return this.idtipoCuenta;
	}

	public void setIdtipoCuenta(int idtipoCuenta) {
		this.idtipoCuenta = idtipoCuenta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}