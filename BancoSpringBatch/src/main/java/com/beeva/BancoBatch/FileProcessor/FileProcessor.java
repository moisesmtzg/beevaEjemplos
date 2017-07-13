package com.beeva.BancoBatch.FileProcessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beeva.BancoBatch.Model.Cliente;
import com.beeva.BancoBatch.Model.Persona;

@Component
public class FileProcessor implements ItemProcessor<Cliente, Persona>{

	public Persona process(Cliente cliente) throws Exception {
		System.out.println("pruebaa aqui");
		Persona persona = new Persona();
		persona.setNombre(cliente.getNombre());
		persona.setApellido(cliente.getApellido());
		return persona;
		
	}

	

}
