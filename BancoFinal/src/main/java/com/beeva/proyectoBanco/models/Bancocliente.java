package com.beeva.proyectoBanco.models;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the bancoclientes database table.
 * 
 */
@Entity
@Table(name="bancoclientes")
@NamedQuery(name="Bancocliente.findAll", query="SELECT b FROM Bancocliente b")
public class Bancocliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBancoCliente;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="idBanco")
	private Banco banco;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public Bancocliente() {
	}

	public int getIdBancoCliente() {
		return this.idBancoCliente;
	}

	public void setIdBancoCliente(int idBancoCliente) {
		this.idBancoCliente = idBancoCliente;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}