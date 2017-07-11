package com.beeva.MODEL;

import java.util.ArrayList;

public class Banco {
	
	
	private ArrayList<Cliente> listClientes= new ArrayList<Cliente>();
	
	public Cliente getCliente(int idCliente){
		Cliente clienteRes = null;
		for(Cliente cliente : listClientes){
			if(cliente.getIdCliente() == idCliente){
				clienteRes = cliente;
			}
		}
		return clienteRes;
		
	}
	
	
	public ArrayList<Cliente> listaClientes(){
		return listClientes;
	}
	
	public boolean agregarCliente(Cliente cliente){
		listClientes.add(cliente);
		return true;
	}
	
	/*
	private Cliente [] listaclientes = new Cliente[10];
	private int ncLientes = 0;
	public boolean agregarClientes(Cliente c){
		boolean bandera = false;
		int nclientes2 = getnClientes();
		if(listaclientes[nclientes2] == null){
			ncLientes++;
			listaclientes[nclientes2] = c;
			bandera = true;
		}else{
			bandera = false;
		}
		return bandera;
	}
	
	public int getnClientes(){
		return ncLientes;
	}
	
	public Cliente getCliente(int idCliente){
		Cliente nuevo = null;
		for(int i = 0; i<getnClientes(); i++){
			Cliente aux = listaclientes[i];
			if(aux.getIdCliente() == idCliente){
				listaclientes[i] = aux;
				nuevo = aux;
			}
		}
		return nuevo;
		
	}
	
	*/
}
