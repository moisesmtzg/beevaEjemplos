
public class Cuenta extends Cliente{

	private double balance;
	
	public Cuenta(String nombre, String apellido, double balance) {
		super(nombre, apellido);
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	/*
	public Cuenta(double balance){
		this.balance=balanca;
	}*/
	
	public double getBalance(){
		return balance; 
	}
	
	public void Deposito(double valor){
		balance += valor;
	}
	
	public void Retiro (double valor){
		if(balance > valor){
			balance -=valor;
		}
	} 
}
