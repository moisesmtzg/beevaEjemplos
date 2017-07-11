import java.util.Random;
import javax.swing.JOptionPane;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejercicio 1
		int resultado=0;
		Random rand = new Random();
		resultado = rand.nextInt(20);
		System.out.println(resultado);
		System.out.println("nuevo ejercicio");
		
		
		//ejercicio 3
		
		String nombre = JOptionPane.showInputDialog("cual es tu nombre");
		String apellido = JOptionPane.showInputDialog("cual es tu apellido");
		Cliente cliente = new Cliente(nombre, apellido);
		
		//ejercio 2
		double valorCuenta = Double.parseDouble(JOptionPane.showInputDialog("ingresa el monto de la cuenta"));
		Cuenta cuenta = new Cuenta(nombre,apellido,valorCuenta);
		//Cuenta cuenta = new Cuenta(valorCuenta);
		cliente.setCuenta(cuenta);
		
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
		while(opcion != 4){
			switch (opcion) {
			case 1:
				JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cliente.getCuenta().getBalance()+"");
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				break;
			case 2:
				double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a depositar"));
				JOptionPane.showConfirmDialog(null, "el nuevo balance es "+cliente.getCuenta().getBalance()+"");
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				break;
			case 3:
				double cantidadRet = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad a retirar"));
				double prueba = cliente.getCuenta().getBalance();
				if(prueba < cantidadRet){
					JOptionPane.showConfirmDialog(null,"No cuentas con los fondos suficientes");
					opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				}else{
					cliente.getCuenta().Retiro(cantidadRet);
					JOptionPane.showConfirmDialog(null,"el nuevo balance es "+cuenta.getBalance()+"");
					opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				}
				break;
			default:
				JOptionPane.showInputDialog("no se puede realizar operacion");
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Balance, 2) Deposito , 3) Retiro y 4)Salir"));
				break;
			}
		}
		
		System.out.println(cliente.getCuenta());
		System.out.println(cuenta.getNombre()+ " "+cuenta.getApellido()+ " balance:" + cliente.getCuenta().getBalance());
		
	}

}
