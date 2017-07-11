package com.beeva.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class Cliente {

	private String nombre;	
	private String apellido;
	private Cuenta cuenta;
	private int idCliente;

	public int getIdCliente(){
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

	//Empieza CRUD

	public void insertCliente(Cliente c, Conexion con){
		Connection conection = con.getConexion();
		int tipoC = 0;
		String tipoCuenta = c.getCuenta().getTipoDeCuenta();
		if(tipoCuenta == "ahorro"){
			tipoC =2;
		}else if(tipoCuenta == "cheque"){
			tipoC=1;
		}
		String query = "insert into banco.cliente(nombre,apellido,idTipoCuenta) values('"+c.getNombre()
				+"','"+c.getApellido()+"',"+tipoC+");";
		try {
			conection.prepareStatement(query).executeUpdate();
			System.out.println("Se inserto un nuevo cliente");
		} catch (SQLException e) {
			System.out.println("no se pudo insertar un nuevo cliente");
			e.printStackTrace();
		}
		con.cerrarConexion();
	}

	public void insertarClienteBanco(Cliente c, Banco b, Conexion con){
		Connection conection = con.getConexion();
		String query ="insert into banco.bancoclientes(idBanco,idCliente) values("+
		b.getIdBanco(b.getNombre(), con)+","+c.getIdClienteDB(c, con)+");";
		
		try {
			conection.prepareStatement(query).executeUpdate();
			System.out.println("se insertaron datos");
		} catch (SQLException e) {
			System.out.println("no se pudo insertar datos en datosclientes");
			e.printStackTrace();
		}
	}
	
	public int getIdClienteDB(Cliente c, Conexion con){
		Connection conection = con.getConexion();
		String query ="select idCliente from banco.cliente where nombre ='"+c.getNombre()+"' and apellido ='"+c.getApellido()+"';";
		int idCliente = 0;
		try {
			ResultSet rs = conection.prepareStatement(query).executeQuery();
			while(rs.next()){
				idCliente = rs.getInt("idCliente");
				System.out.println("se ha obtenido el id del cliente");
			}
		} catch (SQLException e) {
			System.out.println("no se ha podido encontrar el cliente");
			e.printStackTrace();
		}
		return idCliente;
	}
	
	public Cliente getCliente(int idCliente, Conexion con){
		Connection conecction = con.getConexion();
		String query="select * from banco.cliente where cliente.idCliente ="+idCliente+";";
		Cliente cliente = new Cliente();
		try {
			ResultSet rs = conecction.prepareStatement(query).executeQuery();
			while(rs.next()){
				cliente.setApellido(rs.getString("apellido"));
				cliente.setNombre(rs.getString("nombre"));
			}
			System.out.println("se pudo obtener cliente");
		}catch (SQLException e) {
			System.out.println("no se pudo realizar la petición");
			e.printStackTrace();
		}
		con.cerrarConexion();
		return cliente;
	}
}
