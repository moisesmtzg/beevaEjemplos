package com.beeva.DAOEJEMPLO.Empleados;

import javax.swing.JOptionPane;

import com.beeva.Model.Employee;
import com.beeva.factory.EmployeeFactory;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Employee empleado = new Employee();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        
        
        empleado.setNombre(JOptionPane.showInputDialog("cual es tu nombre"));
    	empleado.setApellido(JOptionPane.showInputDialog("cual es tu apellido"));
    	empleado.setStore(1);
    	employeeFactory.getImpl(empleado);
    }
}
