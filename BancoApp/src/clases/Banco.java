package clases;

import java.util.ArrayList;

public class Banco{

	private ArrayList<Cliente> lclientes = new ArrayList<Cliente>();
	private int nCLuentes = 0;
	
	public ArrayList<Cliente> getCliente(){
		return lclientes;
	}
	
	public void addCliente(Cliente cliente){
		lclientes.add(cliente);
		nCLuentes++;
	}
	
	public int getnCLuentes() {
		return nCLuentes;
	}
	
	public void setnCLuentes(int nCLuentes) {
		this.nCLuentes = nCLuentes;
	}
	
	
}
