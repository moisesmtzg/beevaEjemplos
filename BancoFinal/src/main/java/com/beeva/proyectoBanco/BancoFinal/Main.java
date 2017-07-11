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
    	
    	
    	//creacion objetos
    	BancoDAO bancoDAO = (BancoDAO)context.getBean(BancoDAOImplementacion.class);
    	Banco banco = new Banco();
    	ClienteDAO clienteDAO = (ClienteDAO)context.getBean(ClienteDAOImplementacion.class);
    	Cliente cliente = new Cliente();
    	Cuenta cuenta = new Cuenta();
    	CuentaDAO cuentaDAO = (CuentaDAO)context.getBean(CuentaDAOImplementacion.class);
    	BancoClienteDAO bancoClienteDAO = (BancoClienteDAO)context.getBean(BancoClienteDAOImplementacion.class);
    	Bancoscliente bancoCliente = new Bancoscliente();
    	Tipocuenta tp = new Tipocuenta();
    	TipoCuentaDAO tpDAO = (TipoCuentaDAO)context.getBean(TipoCuentaDAOImplementacion.class);
    	
    	//llenado objetos
    	String bancoNombre = JOptionPane.showInputDialog("Ingresa el nombre de tu banco");
    	String nombreCliente = JOptionPane.showInputDialog("Cual es el nombre del cliente");
    	String apllidoCliente = JOptionPane.showInputDialog("Cual es el apellido del cliente");
    	int tipoCuenta = Integer.parseInt(JOptionPane.showInputDialog("cuenta de tipo 1)cheque  2)ahorro"));
    	
    	
    	//banco
    	banco.setNombre(bancoNombre);
    	bancoDAO.agregarBanco(banco);
    	System.out.println("banco guardado "+banco.getNombre());
    	
    	//cliente
    	cliente.setNombre(nombreCliente);
    	cliente.setApellido(apllidoCliente);
      	//bancoCLiente
    	bancoCliente.setBanco(banco);
      	bancoCliente.setCliente(cliente);
      	List<Bancoscliente> listaBancoClientes = new ArrayList<Bancoscliente>();
    	listaBancoClientes.add(bancoCliente);
    	banco.setBancosclientes(listaBancoClientes);
      	
    	//cuenta
      	tp = tpDAO.getTipoCuenta(tipoCuenta);
    	cuenta.setTipocuenta(tp);
    	cuenta.setCliente(cliente);
    	List<Cuenta> listC = new ArrayList<Cuenta>();
    	listC.add(cuenta);
    	cliente.setCuentas(listC);
      	
      	//guardar local antes de bd
    	cliente.setBancosclientes(listaBancoClientes);
    	
    	System.out.println("intentando guardar cliente-banco");
    	bancoClienteDAO.agregarClienteBanco(bancoCliente);
    	System.out.println("guardado en base relacion clienre-banco");
    	System.out.println("intentando guardar cliente");
      	clienteDAO.saveCliente(cliente);
      	System.out.println("cliente guardado"+cliente.getNombre());
      	System.out.println("intendando guardar cuenta");
    	cuentaDAO.agregarCuenta(cuenta);
    	System.out.println("se agrego cuenta "+cuenta);
      	
    	
    	
    	
    	//impresion objetos
    	/*List<Bancoscliente> listallena = banco.getBancosclientes();
    	for(Bancoscliente bcnow : listallena){
    		Banco m = bcnow.getBanco();
    		Cliente c = clienteDAO.getCliente(bcnow.getCliente().getIdcliente());    	
    		System.out.println(m.toString()+ c.toString());
    	}*/
    }
}
