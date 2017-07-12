package com.beeva.proyectoBanco.DAO;

import java.util.List;

import com.beeva.proyectoBanco.models.Banco;

public abstract class BancoDAO {

	public abstract Banco agregarBanco(Banco b);
	public abstract Banco obtenerBanco(int idBanco);
	public abstract void eliminarBanco(int idBanco);
	public abstract List<Banco> getAllBancos();
} 
