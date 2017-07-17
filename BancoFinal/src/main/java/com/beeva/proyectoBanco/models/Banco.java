package com.beeva.proyectoBanco.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@Table(name="banco")
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbanco;

	private String nombre;

	//bi-directional many-to-one association to Bancoscliente
	@OneToMany(mappedBy="banco")
	private List<Bancoscliente> bancosclientes;

	public int getIdbanco() {
		return this.idbanco;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Bancoscliente> getBancosclientes() {
		return this.bancosclientes;
	}

	public void setBancosclientes(List<Bancoscliente> bancosclientes) {
		this.bancosclientes = bancosclientes;
	}

	public Bancoscliente addBancoscliente(Bancoscliente bancoscliente) {
		getBancosclientes().add(bancoscliente);
		bancoscliente.setBanco(this);

		return bancoscliente;
	}

	public Bancoscliente removeBancoscliente(Bancoscliente bancoscliente) {
		getBancosclientes().remove(bancoscliente);
		bancoscliente.setBanco(null);

		return bancoscliente;
	}

	@Override
	public String toString() {
		return "Banco [idbanco=" + idbanco + ", nombre=" + nombre
				+ ", bancosclientes=" + bancosclientes + "]";
	}

	
}