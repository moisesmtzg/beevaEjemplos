package com.beeva.spring.saluda;

import org.springframework.beans.factory.annotation.Autowired;

public class Saluda {

	private String tiempo;
	
	
	@Autowired
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	
	public void Saludar(){
		System.out.println("buenos días  "+persona.getNombre());
	}
	
}
