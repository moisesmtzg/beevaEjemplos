package com.beeva.SpringBanco.BancoSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.MODEL.Banco;
import com.beeva.MODEL.Cliente;
import com.beeva.MODEL.Cuenta;


public class Main 
{
    public static void main( String[] args )
    {
    	//empieza uso String
    	ApplicationContext context = new ClassPathXmlApplicationContext("BancoBeans.xml");
    	Banco banco = (Banco)context.getBean("bancoBean");
    	
    	
    	//impresión
    	for(Cliente c :banco.listaClientes()){
   		 System.out.println(c.toString());
   	 }
    }
}
