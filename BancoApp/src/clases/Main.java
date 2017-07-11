package clases;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco banco = new Banco();
		Cliente cliente;
		for(int i = 0;i<2;i++){
			cliente = new Cliente(JOptionPane.showInputDialog("cual es tu nombre"), JOptionPane.showInputDialog("cual es tu apellido"));
			int tipoCuenta= Integer.parseInt(JOptionPane.showInputDialog("Que tipo de cuenta deseas 1)ahorro o 2)de cheques"));
			switch (tipoCuenta){
			case 1:
				cliente.setCuenta(new CuentaAhorro(Double.parseDouble(JOptionPane.showInputDialog("ingresa la cantidad de tu cuenta"))));
				cliente.setTipoCuenta("Cuenta Ahorro");
				int opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				while(opcion != 4){
					switch (opcion) {
					case 1:
						JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					case 2:
						double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a depositar"));
						cliente.getCuenta().Deposito(cantidad);
						JOptionPane.showConfirmDialog(null, "el nuevo balance es "+cliente.getCuenta().getBalance()+"");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					case 3:
						double cantidadRet = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a retirar"));
						if(cliente.getCuenta().Retiro(cantidadRet) == false){
							JOptionPane.showConfirmDialog(null,"No cuentas con los fondos suficientes");
							opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						}else{
							cliente.getCuenta().Retiro(cantidadRet);
							JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
							opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						}
						break;
					default:
						JOptionPane.showInputDialog("no se puede realizar operacion");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					}
				}
				break;
			case 2:
				cliente.setCuenta(new CuentaCheques(Double.parseDouble(JOptionPane.showInputDialog("ingresa la cantidad de tu cuenta"))));
				cliente.setTipoCuenta("Cuenta de cheques");
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				while(opcion != 4){
					switch (opcion) {
					case 1:
						JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					case 2:
						double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a depositar"));
						cliente.getCuenta().Deposito(cantidad);
						JOptionPane.showConfirmDialog(null, "el nuevo balance es "+cliente.getCuenta().getBalance()+"");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					case 3:
						double cantidadRet = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a retirar"));
						if(cliente.getCuenta().Retiro(cantidadRet) == false){
							JOptionPane.showConfirmDialog(null,"No cuentas con los fondos suficientes");
							opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						}else{
							cliente.getCuenta().Retiro(cantidadRet);
							JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
							opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						}
						break;
					default:
						JOptionPane.showInputDialog("no se puede realizar operacion");
						opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
						break;
					}
				}
				break;
				default:
					break;
			}
			
			
				
			
			banco.addCliente(cliente);
		}
		for(Cliente c : banco.getCliente()){
			System.out.println(c.getNombre()+" "+c.getApellido()+" con "+c.getTipoCuenta()+" balance :"+ c.getCuenta().getBalance());
		}

	}

}
