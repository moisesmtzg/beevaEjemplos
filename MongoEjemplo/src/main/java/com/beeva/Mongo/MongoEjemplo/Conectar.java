package com.beeva.Mongo.MongoEjemplo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Conectar {

	String param;
	int puerto;
	MongoClient mongo;
	
	
	
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



	public void Conect(){
		mongo = null;
		try {
			mongo = new MongoClient(param,puerto);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
