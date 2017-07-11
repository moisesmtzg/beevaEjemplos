package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

	Connection con = null;
	
	public Conexion(){
		
	}
	
	public Connection getConexion(){
		String dataBase ="banco";
		String user = "root";
		String passUser = "root";
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBase,user,passUser);
			System.out.println("Conexión exitosa ");
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("no se pudo realizar la conexión ");
		}
		return con;
	}
	
	public void cerrarConexion(){
		try {
			con.close();
			System.out.println("conexión cerrada");
		} catch (SQLException e) {
			System.out.println("problema al cerrar la conexión");
			e.printStackTrace();
		}
	}
	
}

