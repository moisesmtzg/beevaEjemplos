package com.beeva.proyectoBanco.DAO;

import java.util.List;

import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Bancoscliente;

public abstract class BancoClienteDAO {
	
	public abstract boolean agregarClienteBanco(Bancoscliente bancoCliente);
	public abstract List<Bancoscliente> obtenerClientesBanco(int idBanco);
	public abstract Banco getBancoCliente(int idCliente);
	
}
