package com.beeva.DAOBANCO.DAO;

import javax.swing.JOptionPane;

import com.beeva.MODEL.Banco;
import com.beeva.MODEL.Cliente;
import com.beeva.MODEL.Cuenta;
import com.beeva.factory.CuentaFactory;
import com.beeva.interfaces.CuentaInterface;

public class Main 
{
    public static void main( String[] args )
    {
    	//Creacion de objeto y fabricas
    	
        Cuenta cuenta = null;
        CuentaFactory cuentaFactory = new CuentaFactory();
        Cliente cliente = null;
        Banco banco = new Banco();
        //llenado info
      
    	for(int i = 0; i<2;i++){
    		cliente=new  Cliente();
    		cliente.setNombre(JOptionPane.showInputDialog("cual es tu nombre"));
    		cliente.setApellido(JOptionPane.showInputDialog("cual es tu apellido"));
    		cliente.setIdCliente(i);
    		cuenta = new Cuenta();
        	cuenta.setTipoDeCuenta(JOptionPane.showInputDialog("1) cuenta de cheques  2)cuenta de ahorro"));
        	cliente.setCuenta(cuenta);
        	CuentaInterface cuentaNow = cuentaFactory.cuentaImpl(cuenta);
        	cuenta.setBalance(Double.parseDouble(JOptionPane.showInputDialog("cual es tu balance")));
        	int opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
			while(opcion != 4){
				switch (opcion) {
				case 1:
					JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
					opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
					break;
				case 2:
					double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a depositar"));
					if(cuentaNow.deposito(cuenta, cantidad)== true){
						JOptionPane.showConfirmDialog(null, "el nuevo balance es "+cliente.getCuenta().getBalance()+"");
					}
					opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
					break;
				case 3:
					double cantidadRet = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a retirar"));
					if(cuentaNow.retiro(cuenta, cantidadRet) == false){
						JOptionPane.showConfirmDialog(null,"No cuentas con los fondos suficientes o es fin de semana");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
					}else{
						JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
					}
					break;
				default:
					JOptionPane.showInputDialog("no se puede realizar operacion");
					opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
					break;
				}
			}//con arrayList
			banco.agregarCliente(cliente);
			//con array normal
			/*
			 banco.agregarClientes(cliente);
			 * */
        }

        //impresion datos con arrayList
    	 for(Cliente c :banco.listaClientes()){
    		 System.out.println(c.toString());
    	 }
    	 
    	 //impresion dats con arreglos normales
    	/*
    	 for(int i=0;i<=banco.getnClientes()-1;i++){
    		 System.out.println(banco.getCliente(i).toString());
    	 }
    	 */
    }
}
