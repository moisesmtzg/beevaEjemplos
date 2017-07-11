package com.beeva.proyectoBanco.DAO;

import com.beeva.proyectoBanco.models.Cliente;

public abstract class ClienteDAO {

	public abstract Cliente getCliente(int idCliente); 
	public abstract Cliente saveCliente(Cliente c);
	public abstract void eliminarCliente(int c);
	public abstract Cliente actualizarCliente(Cliente c);
}
