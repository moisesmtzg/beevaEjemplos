package com.beeva.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beeva.BancoMySQLJDBC.BancoMySQLJDBC.Conexion.*;

public class Cuenta {

	private double balance;
	private String tipoDeCuenta;

	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(String cuenta) {
		this.tipoDeCuenta = cuenta;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//CRUD
	
	public void insertarCuenta(int idCliente, Cuenta cuenta, Conexion con){
		Connection connet = con.getConexion();
		String tipoC = cuenta.getTipoDeCuenta();
		int tipoCuenta = 0;
		if(tipoC  == "chuque"){
			tipoCuenta = 1;
		}else if(tipoC == "ahorro"){
			tipoCuenta= 2;
		}
		String query = "insert into banco.cuenta(balance,idCliente,idTipoCuenta) values("+
					cuenta.getBalance()+","+ idCliente+","+tipoCuenta+");";
		
		try {
			connet.prepareStatement(query).executeUpdate();
			System.out.println("se agrego cuenta");
		} catch (SQLException e) {
			System.out.println("no se pudo insertar cuenta");
			e.printStackTrace();
		}
		con.cerrarConexion();
	}
	
	public Cuenta getCuenta(int idCuenta, Conexion con){
		Connection connection = con.getConexion();
		String query = "select * from banco.cuenta where idCuenta ="+idCuenta+";";
		Cuenta cuenta = new Cuenta();
		try {
			ResultSet rs = connection.prepareStatement(query).executeQuery();
			while(rs.next()){
				cuenta.setBalance(new Double(rs.getBigDecimal("balance").doubleValue()));
				int idTipo = rs.getInt("idTipoCuenta");
				if(idTipo == 1){
					cuenta.setTipoDeCuenta("cheques");
				}else if(idTipo == 2){
					cuenta.setTipoDeCuenta("ahorro");
				}
			}
		} catch (SQLException e) {
			System.out.println("no se pudo obtener la cuenta");
			e.printStackTrace();
		}
		con.cerrarConexion();
		return cuenta;
	}
}
