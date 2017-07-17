package com.beeva.proyectoBanco.mongoUtilities;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;

public class Conectar {

	String param = "localhost";
	int puerto = 27017;
	MongoClient mongo;
	private static final Logger LOGGER = Logger.getLogger( Conectar.class.getName() );
	
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}



	public int getPuerto() {
		return puerto;
	}



	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}



	public MongoClient getMongo() {
		return mongo;
	}



	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}



	public void MongoConectar(){
		mongo = null;
		try {
			mongo = new MongoClient(param,puerto);
		} catch (Exception e) {
			LOGGER.log(Level.FINE,"context", e);
		}
	}
}
