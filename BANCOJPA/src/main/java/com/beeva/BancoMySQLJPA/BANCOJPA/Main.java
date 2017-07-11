package com.beeva.BancoMySQLJPA.BANCOJPA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.BancoMySQLJPA.dao.UserDAO;
import com.beeva.BancoMySQLJPA.implementacion.UserDAOImplentation;
import com.beeva.models.User;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        User n = new User();
        n.setNombre("pedro");
        n.setDireccion("cerrada 1");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
        UserDAO userDAO= (UserDAO)context.getBean(UserDAOImplentation.class);
        userDAO.save(n);
    }
}
