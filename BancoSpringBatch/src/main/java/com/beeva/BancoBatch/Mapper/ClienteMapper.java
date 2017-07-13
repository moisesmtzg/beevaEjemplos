package com.beeva.BancoBatch.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beeva.BancoBatch.Model.Cliente;
import com.beeva.BancoBatch.Model.Persona;

public class ClienteMapper implements RowMapper<Cliente>{

	public Cliente mapRow(ResultSet rs,int rowNum) throws SQLException{
		Cliente cliente = new Cliente();
		
		cliente.setNombre(rs.getString("nombre"));
		cliente.setApellido(rs.getString("apellido"));
		
		return cliente;
	}
}
