package clases;


public class CuentaAhorro extends Cuenta{

	public CuentaAhorro(double balance) {
		super(balance);
	}

	public boolean Retiro(double retiro){
		boolean bandera = false;
		if(balance>=5000){
			balance -=retiro;
			bandera = true;
		}else{
			bandera = false;
		}
		return bandera;
	}
	
	public void Deposito(double deposito){
		balance+= deposito;
	}
}
