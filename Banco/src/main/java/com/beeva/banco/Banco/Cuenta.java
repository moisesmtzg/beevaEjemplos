package com.beeva.banco.Banco;


public class Cuenta extends Cliente{

	protected double balance;
	
	public Cuenta(String nombre, String apellido, double balance) {
		super(nombre, apellido);
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	
	public Cuenta(){
		
	}
	
	public Cuenta(double balance){
		this.balance = balance;
	}
	
	public void setBalance(double balanceN){
		balance +=balanceN;
	}
	public double getBalance(){
		return balance; 
	}
	
	public void Deposito(double valor){
		balance += valor;
	}
	
	public boolean Retiro (double valor){
		boolean bandera = false;
		if(balance > valor){
			balance -=valor;
			bandera = true;
		}else{
			bandera = false;
		}
		return bandera;
	} 
}
