package com.beeva.proyectoBanco.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condiciones {

	public Condiciones(){
		
	}
	
	public boolean palabraCorrecta(String palabra){
		boolean bandera = false;
		String patternString = "^[a-zA-Z]+";
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(palabra);
		if(match.matches() == true){
			bandera = true;
		}else{
			bandera = false;
		}
		return bandera;
	}
	
	public boolean cantidadCorrecta(Double cantidad){
		boolean bandera = false;
		String patternInt = "^[0-9]*.[0-9]*";
		Pattern pattern = Pattern.compile(patternInt);
		Matcher match = pattern.matcher(cantidad.toString());
		if(match.matches() == true){
			if(cantidad >0){
				bandera = true;
			}else{
				bandera = false;
			}
		}else{
			bandera = false;
		}
		return bandera;
	}
	
}
