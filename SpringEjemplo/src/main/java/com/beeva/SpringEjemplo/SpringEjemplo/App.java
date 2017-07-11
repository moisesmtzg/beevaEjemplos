package com.beeva.SpringEjemplo.SpringEjemplo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.spring.saluda.Saluda;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		Saluda saluda = (Saluda)context.getBean("saludador");
		saluda.Saludar();
	}
}
