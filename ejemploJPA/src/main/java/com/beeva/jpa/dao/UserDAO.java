package com.beeva.jpa.dao;

import com.beeva.jpa.model.User;

public abstract class UserDAO {

	public abstract User saveUser(User u);
	public abstract User getUser(int idUser);
	public abstract void deleteUser(int idUser);

}
