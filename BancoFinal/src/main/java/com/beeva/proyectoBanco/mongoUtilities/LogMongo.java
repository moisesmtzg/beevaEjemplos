package com.beeva.proyectoBanco.mongoUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Cliente;
import com.beeva.proyectoBanco.models.Cuenta;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class LogMongo {

	private Conectar conectar = new Conectar();
	private String fecha;
	
	public LogMongo(){
		
	}
	
	public void agregar(Banco banco){
		conectar.MongoConectar();
		DB db = conectar.getMongo().getDB("BancoDB");
		fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		DBCollection tabla = db.getCollection("Log");
		BasicDBObject document = new BasicDBObject();
		document.put("nombreBanco", banco.getNombre());
		document.put("idBancoDB", banco.getIdbanco());
		document.put("fechaCreacion", fecha);
		tabla.insert(document);
	}
	
	public void agregar(Cuenta cuenta){
		conectar.MongoConectar();
		DB db = conectar.getMongo().getDB("BancoDB");
		fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		DBCollection tabla = db.getCollection("Log");
		BasicDBObject document = new BasicDBObject();
		document.put("tipoCuenta", cuenta.getTipocuenta().getNombre());
		document.put("idCuentaDB", cuenta.getIdcuenta());
		document.put("idCliente", cuenta.getCliente().getIdcliente());
		document.put("balance", cuenta.getBalance().toString());
		document.put("fechaCreacion", fecha);
		tabla.insert(document);
	}
	
	public void agregar(Cliente cliente){
		conectar.MongoConectar();
		DB db = conectar.getMongo().getDB("BancoDB");
		fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		DBCollection tabla = db.getCollection("Log");
		BasicDBObject document = new BasicDBObject();
		document.put("nombreCliente", cliente.getNombre());
		document.put("apellidoCliente", cliente.getApellido());
		document.put("idClienteDB", cliente.getIdcliente());
		document.put("fechaCreacion", fecha);
		tabla.insert(document);
	}
}
