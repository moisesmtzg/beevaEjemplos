package com.beeva.proyectoBanco.BancoFinal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSInput;

import com.beeva.proyectoBanco.DAO.BancoClienteDAO;
import com.beeva.proyectoBanco.DAO.BancoDAO;
import com.beeva.proyectoBanco.DAO.ClienteDAO;
import com.beeva.proyectoBanco.DAO.CuentaDAO;
import com.beeva.proyectoBanco.DAO.TipoCuentaDAO;
import com.beeva.proyectoBanco.implementacion.BancoClienteDAOImplementacion;
import com.beeva.proyectoBanco.implementacion.BancoDAOImplementacion;
import com.beeva.proyectoBanco.implementacion.ClienteDAOImplementacion;
import com.beeva.proyectoBanco.implementacion.CuentaDAOImplementacion;
import com.beeva.proyectoBanco.implementacion.TipoCuentaDAOImplementacion;
import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Bancoscliente;
import com.beeva.proyectoBanco.models.Cliente;
import com.beeva.proyectoBanco.models.Cuenta;
import com.beeva.proyectoBanco.models.Tipocuenta;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
    	
    	Banco banco = new Banco();
    	banco.setNombre(JOptionPane.showInputDialog("Cual es el nombre del banco"));
    	BancoDAO bancoDAO = (BancoDAO)context.getBean(BancoDAOImplementacion.class);
    	Banco banconActual = bancoDAO.agregarBanco(banco);
    	
    	Cliente cliente = new Cliente();
    	cliente.setNombre(JOptionPane.showInputDialog("cual es el nombre del cliente"));
    	cliente.setApellido(JOptionPane.showInputDialog("cual es el apellido del cliente"));
    	ClienteDAO clienteDAO = (ClienteDAO)context.getBean(ClienteDAOImplementacion.class);
    	Cliente clienteActual = clienteDAO.saveCliente(cliente);
    	
    	Bancoscliente bancoCliente = new Bancoscliente();
    	bancoCliente.setBanco(banconActual);
    	bancoCliente.setCliente(clienteActual);
    	BancoClienteDAO bancoclienteDAO = (BancoClienteDAO)context.getBean(BancoClienteDAOImplementacion.class);
    	bancoclienteDAO.agregarClienteBanco(bancoCliente);
    	
    	List<Bancoscliente> listaBancoCliente = new ArrayList<Bancoscliente>();
    	listaBancoCliente.add(bancoCliente);

    	banconActual.setBancosclientes(listaBancoCliente);
    	clienteActual.setBancosclientes(listaBancoCliente);
    	
    	
    }
}
