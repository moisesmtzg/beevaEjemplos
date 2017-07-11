package com.beeva.MySQL.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main( String[] args ) 
	{
		Connection con = null;

		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","root");
		}catch(SQLException s ){
			System.out.println("fallo en la conexión");
			s.printStackTrace();
			return;
		}
		
		if(con != null){
			System.out.println("ya se puede hacer algo");
			String insert = "insert into empleado (nombre) values ('Luis');";
			String query = "select * from empleado;";
			try{
				con.prepareStatement(insert).executeUpdate();
				ResultSet rs = con.prepareStatement(query).executeQuery();
				while(rs.next()){
					System.out.println(rs.getString("nombre"));
				}
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("ya valio");
				
			}
		}else{
			System.out.println("no se puede hacer nada");
		}
	}
}
