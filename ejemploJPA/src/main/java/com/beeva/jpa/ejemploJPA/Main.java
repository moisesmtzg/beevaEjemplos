package com.beeva.jpa.ejemploJPA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.jpa.dao.UserDAO;
import com.beeva.jpa.implementation.UserImplementation;
import com.beeva.jpa.model.User;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
    	UserDAO uDAO = (UserDAO)context.getBean(UserImplementation.class);
    	/*
    	User n = new User();
    	n.setNombre("luis");
    	n.setDireccion("Calle 2");
    	uDAO.saveUser(n);
    	*/
    	uDAO.deleteUser(2);
    }
}
