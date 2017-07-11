package com.beeva.BancoMySQLJDBC.BancoMySQLJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.MODEL.Banco;
import com.beeva.MODEL.Cliente;
import com.beeva.MODEL.Cuenta;

import Conexion.Conexion;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Conexion con = new Conexion();
        Banco banco = new Banco();
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        
        //prueba BD
        
        //banco
        banco.setNombre("HSBC");
        banco.agregarBanco(banco, con);
        //cliente
        cliente.setNombre("Salvadora");
        cliente.setApellido("Martinez");
        cuenta.setBalance(55000.00);
        cuenta.setTipoDeCuenta("ahorro");
        cliente.setCuenta(cuenta);
        cliente.insertCliente(cliente, con);
        //cuentaa

        cuenta.insertarCuenta(cliente.getIdClienteDB(cliente, con), cuenta, con);
        cliente.insertarClienteBanco(cliente, banco, con);
        
    	for(Cliente c : banco.getClientesBanco(banco.getNombre(), con)){
    		System.out.println(c);
    	}
    }
}
