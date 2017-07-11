package clases;

public class CuentaCheques extends Cuenta{
	
	public CuentaCheques(double balance) {
		super(balance);
	}
	
	public boolean Retiro(double retiro){
		boolean bandera = false;
		if(retiro <= 5000){
			if(balance >= retiro){
				balance-=retiro;
				bandera = true;
			}
		}else{
			bandera = false;
		}
		return bandera;
	}

}
