package com.beeva.proyectoBanco.BancoFinal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
import com.beeva.proyectoBanco.mongoUtilities.LogMongo;
import com.beeva.proyectoBanco.utilities.Condiciones;
import com.beeva.proyectoBanco.utilities.DroolsUtilities;
import com.beeva.proyectoBanco.utilities.Sospecha;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main( String[] args )
	{
				
		LogMongo log = new LogMongo();
		Condiciones condiciones = new Condiciones();
		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
		String palabraNoValida = "Palabra contiene caracteres no validos";
		String opcionesCuenta = "Que deseas hacer 1)Saldo 2)Deposito 3)Retiro 4)Salir (numero)";
		//Agregar tipos de cuenta a la base
		Tipocuenta tipoCuenta1  = new Tipocuenta();
		tipoCuenta1.setNombre("cheque");
		Tipocuenta tipoCuenta2  = new Tipocuenta();
		tipoCuenta2.setNombre("ahorro");
		TipoCuentaDAO tipoCuentaDAOInit = (TipoCuentaDAO)context.getBean(TipoCuentaDAOImplementacion.class);
		tipoCuentaDAOInit.agregarTipoCuenta(tipoCuenta1);
		tipoCuentaDAOInit.agregarTipoCuenta(tipoCuenta2);

		
		int opcionBanco = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar un banco 1)si 2 )no (numero) "));
		while(opcionBanco != 2){
			Banco banco = new Banco();
			String nombreBanco =JOptionPane.showInputDialog("Cual es el nombre del banco");
			while(condiciones.palabraCorrecta(nombreBanco) == false){
				JOptionPane.showMessageDialog(null, palabraNoValida );
				nombreBanco =JOptionPane.showInputDialog("Cual es el nombre del banco");
			}
			banco.setNombre(nombreBanco);
			BancoDAO bancoDAO = (BancoDAO)context.getBean(BancoDAOImplementacion.class);

			Banco banconActual = bancoDAO.agregarBanco(banco);
			log.agregar(banconActual);
			int opcionCliente = 1;
			while(opcionCliente !=2){
				Cliente cliente = new Cliente();
				String nombreCliente =JOptionPane.showInputDialog("cual es el nombre del cliente"); 
				while(condiciones.palabraCorrecta(nombreCliente) == false){
					JOptionPane.showMessageDialog(null, palabraNoValida);
					nombreCliente =JOptionPane.showInputDialog("cual es el nombre del cliente");
				}
				cliente.setNombre(nombreCliente);
				String apellidoCliente = JOptionPane.showInputDialog("cual es el apellido del cliente");
				while(condiciones.palabraCorrecta(apellidoCliente) == false){
					JOptionPane.showMessageDialog(null, palabraNoValida);
					apellidoCliente = JOptionPane.showInputDialog("cual es el apellido del cliente");
				}
				cliente.setApellido(apellidoCliente);
				ClienteDAO clienteDAO = (ClienteDAO)context.getBean(ClienteDAOImplementacion.class);
				Cliente clienteActual = clienteDAO.saveCliente(cliente);
				log.agregar(clienteActual);

				Bancoscliente bancoCliente = new Bancoscliente();
				bancoCliente.setBanco(banconActual);
				bancoCliente.setCliente(clienteActual);
				BancoClienteDAO bancoclienteDAO = (BancoClienteDAO)context.getBean(BancoClienteDAOImplementacion.class);
				bancoclienteDAO.agregarClienteBanco(bancoCliente);

				List<Bancoscliente> listaBancoCliente = new ArrayList<Bancoscliente>();
				listaBancoCliente.add(bancoCliente);

				banconActual.setBancosclientes(listaBancoCliente);
				clienteActual.setBancosclientes(listaBancoCliente);

				int opcionCuenta = 1;
				while(opcionCuenta != 2){
					Cuenta cuenta = new Cuenta();
					cuenta.setCliente(clienteActual);
					Tipocuenta tp;
					int tipoCuenta = Integer.parseInt(JOptionPane.showInputDialog("cuenta de tipo 1)Cheque 2)Ahorro (ingresa el número)"));
					TipoCuentaDAO tipoCuentaDAO = (TipoCuentaDAO)context.getBean(TipoCuentaDAOImplementacion.class);
					tp = tipoCuentaDAO.getTipoCuenta(tipoCuenta);
					cuenta.setTipocuenta(tp);
					BigDecimal b = new BigDecimal(0, MathContext.DECIMAL64);
					cuenta.setBalance(b);
					CuentaDAO cuentaDAO = (CuentaDAO)context.getBean(CuentaDAOImplementacion.class);
					Cuenta cuentaActual = cuentaDAO.agregarCuenta(cuenta);
					int opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionCuenta));
					while(opcion != 4){
						switch (opcion){
						case 1:
							log.agregar(cuentaActual);
							JOptionPane.showMessageDialog(null, "la cuenta :" +cuentaActual.getIdcuenta()+"   tiene  $"+cuentaActual.getBalance());
							opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesCuenta));
							break;
						case 2:
							Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("cual es la cantidad a depositar"));
							DroolsUtilities du = new DroolsUtilities();
							Sospecha sos = new Sospecha();
							sos.setCantidad(cantidad);
							sos.setBalance(cuentaActual.getBalance().doubleValue());
							sos.setTipoCuenta(cuentaActual.getTipocuenta().getIdtipocuenta());
							du.calcularSospecha(sos);
							while(condiciones.cantidadCorrecta(cantidad) == false){
								JOptionPane.showMessageDialog(null, "la cantidad debe de ser positiva");
								cantidad = Double.parseDouble(JOptionPane.showInputDialog("cual es la cantidad a depositar"));
							}
							if(cuentaDAO.deposito(cantidad, clienteActual, cuentaActual) == false){
								JOptionPane.showMessageDialog(null, "A la cuenta " +cuentaActual.getIdcuenta()+" no se le pudo realizar el deposito ");
								opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesCuenta));
							}else{
								log.agregar(cuentaActual);
								JOptionPane.showMessageDialog(null, "la cuenta " +cuentaActual.getIdcuenta()+" tiene $"+cuentaActual.getBalance());
								opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesCuenta));
							}
							break;
						case 3:
							Double cantidadRetiro = Double.parseDouble(JOptionPane.showInputDialog("cual es la cantidad a retirar"));
							while(condiciones.cantidadCorrecta(cantidadRetiro) == false){
								JOptionPane.showMessageDialog(null, "la cantidad debe de ser positiva");
								cantidadRetiro = Double.parseDouble(JOptionPane.showInputDialog("cual es la cantidad a depositar"));
							}
							if(cuentaDAO.retiro(cantidadRetiro,clienteActual, cuentaActual) == false){
								JOptionPane.showMessageDialog(null, "No se pudo realizar el retiro a la cuenta " +cuentaActual.getIdcuenta()+" ya que no tiene los fondos suficientes o es fin de semana");
								opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesCuenta));
							}else{
								log.agregar(cuentaActual);
								JOptionPane.showMessageDialog(null, "la cuenta " +cuentaActual.getIdcuenta()+"tiene "+cuentaActual.getBalance());
								opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesCuenta));
							}
							break;
						}
						
					}
					opcionCuenta = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar otra cuenta al cliente 1)si 2)no (numero) "));
				}
				opcionCliente = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar otro cliente al mismo banco 1)si 2)no (numero)"));
			}
			opcionBanco = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar un banco 1)si 2 )no (numero) "));
		}
	
		
		Main n = new Main();
		n.imprimirTodo(context);
		
	}

	public void imprimirTodo(ApplicationContext context){
		BancoDAO bancoDAO  = (BancoDAO)context.getBean(BancoDAOImplementacion.class);
		BancoClienteDAO bancoClienteDAo = (BancoClienteDAO)context.getBean(BancoClienteDAOImplementacion.class);
		CuentaDAO cuentaDAO = (CuentaDAO)context.getBean(CuentaDAOImplementacion.class);

		List<Banco>listaBanco = bancoDAO.getAllBancos();
		for(Banco bancoImprimir : listaBanco){
			List<Bancoscliente>listaBancoCl =  bancoClienteDAo.obtenerClientesBanco(bancoImprimir.getIdbanco());
			for(Bancoscliente bc : listaBancoCl){
				if(bc.getBanco().getIdbanco() == bancoImprimir.getIdbanco()){
					List<Cuenta> listaCuentasL = cuentaDAO.getTodasCuentas();
					for(Cuenta cuen : listaCuentasL){
						if(cuen.getCliente().getIdcliente() == bc.getCliente().getIdcliente()){
							JOptionPane.showMessageDialog(null, bancoImprimir.getNombre()+" "+ bc.getCliente()+" "+cuen.toString()+" "+cuen.getTipocuenta().getNombre());
						}
					}
				}
			}
		}
	}
}
