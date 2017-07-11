package com.beeva.BancoMySQLJPA.dao;

import org.springframework.stereotype.Component;

import com.beeva.models.User;

public abstract class UserDAO {

	public abstract void save(User u);
	public abstract User getUser(int idUser);
	
}
