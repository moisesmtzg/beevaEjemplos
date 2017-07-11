package com.beeva.proyectoBanco.models;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBanco;

	private String nombreBanco;

	//bi-directional many-to-one association to Bancocliente
	@OneToMany(mappedBy="banco")
	private List<Bancocliente> bancoclientes;

	public Banco() {
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombreBanco() {
		return this.nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public List<Bancocliente> getBancoclientes() {
		return this.bancoclientes;
	}

	public void setBancoclientes(List<Bancocliente> bancoclientes) {
		this.bancoclientes = bancoclientes;
	}

	public Bancocliente addBancocliente(Bancocliente bancocliente) {
		getBancoclientes().add(bancocliente);
		bancocliente.setBanco(this);

		return bancocliente;
	}

	public Bancocliente removeBancocliente(Bancocliente bancocliente) {
		getBancoclientes().remove(bancocliente);
		bancocliente.setBanco(null);

		return bancocliente;
	}

}