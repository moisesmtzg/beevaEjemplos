package com.beeva.Mongo.MongoEjemplo;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main( String[] args )
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		Conectar con = (Conectar)context.getBean("conectar");
		con.Conect();
		DB db = con.getMongo().getDB("testdb");
		
		DBCollection tabla = db.getCollection("users");
		BasicDBObject document = new BasicDBObject();
		document.put("nombre", "Moises");
		document.put("edad", 25);
		tabla.insert(document);




	}
}
