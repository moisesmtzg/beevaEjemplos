package com.beeva.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;

public class Banco {
	
	private int idBanco;
	private String nombre;
	private ArrayList<Cliente> listClientes= new ArrayList<Cliente>();
	
	public int getIdBanco() {
		return idBanco;
	}

	public Cliente getCliente(int idCliente){
		Cliente clienteRes = null;
		for(Cliente cliente : listClientes){
			if(cliente.getIdCliente() == idCliente){
				clienteRes = cliente;
			}
		}
		return clienteRes;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cliente> listaClientes(){
		return listClientes;
	}
	
	public void agregarCLientesBD(Banco banco, Cliente cliente, Conexion con){
		Connection conect = con.getConexion();
		String query = "insert into banco.bancoclientes(idBanco,idCliente) values("+
		(banco.getIdBanco(banco.getNombre(), con))+","+cliente.getIdClienteDB(cliente,con)+");";
		
		try {
			conect.prepareStatement(query).executeUpdate();
			System.out.println("se guardo el cliente con su banco");
		} catch (SQLException e) {
			System.out.println("no se pudo insertar");
			e.printStackTrace();
		}
		con.cerrarConexion();
	}
	
	public boolean agregarCliente(Cliente cliente){
		listClientes.add(cliente);
		return true;
	}
	
	public void agregarBanco(Banco banco, Conexion con){
		Connection connection = con.getConexion();
		String query = "insert into banco.banco(nombreBanco) values('"+banco.getNombre()+"');";
		try {
			connection.prepareStatement(query).executeUpdate();
			System.out.println("se agregó un banco nuevo");
		} catch (SQLException e) {
			System.out.println("no se ha podido agregar un banco");
			e.printStackTrace();
		}
		con.cerrarConexion();
	}
	
	public int getIdBanco(String nombre, Conexion con){
		Connection connection = con.getConexion();
		int i = 0;
		String query = "select * from banco.banco where nombreBanco ='"+nombre+"';";
		try {
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			System.out.println("si se encontro un banco con ese nombre");
			while(rs.next()){
				i = rs.getInt("idBanco");
				
			}
		} catch (SQLException e) {
			System.out.println("no se pudo regresar el banco");
			e.printStackTrace();
		}
		con.cerrarConexion();
		return i;
	}
	
	public ArrayList<Cliente> getClientesBanco(String nombreBanco,Conexion con){
		Connection conect = con.getConexion();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		int idBanco = getIdBanco(nombreBanco, con);
		String query = "select idCliente from banco.bancoclientes where idBanco ="+idBanco+";";
		try {
			ResultSet rs =conect.prepareStatement(query).executeQuery();
			while(rs.next()){
				Cliente c= new Cliente();
				c.getCliente(rs.getInt("idCliente"), con);
				listaClientes.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaClientes;
	}

}
