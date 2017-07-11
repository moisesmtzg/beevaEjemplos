package com.beeva.factory;


import com.beeva.Model.Employee;
import com.beeva.implementacion.EmployeeDAOImplArray;
import com.beeva.interfaces.EmployeeInterface;

public class EmployeeFactory {
	
	public EmployeeInterface getImpl(Employee e){
		EmployeeInterface employeeDAO = new EmployeeDAOImplArray();
		if(e.getStore() == 1){
			
		}
		return employeeDAO;
	}

}
