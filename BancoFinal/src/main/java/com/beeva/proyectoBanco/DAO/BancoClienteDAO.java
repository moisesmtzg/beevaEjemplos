package com.beeva.proyectoBanco.DAO;

import java.util.ArrayList;

import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Bancoscliente;
import com.beeva.proyectoBanco.models.Cliente;

public abstract class BancoClienteDAO {
	
	public abstract boolean agregarClienteBanco(Bancoscliente bancoCliente);
	public abstract ArrayList<Cliente> obtenerClientesBanco(int idBanco);
	public abstract Banco getBancoCliente(int idCliente);
	
}
