package com.beeva.interfaces;

import java.util.ArrayList;

import com.beeva.Model.Employee;


public interface EmployeeInterface {
	
	public boolean addEmployee(Employee empleado);
	public boolean updateEmployee(Employee empleado);
	public boolean deleteEmployee(int numEmpleado);
	public Employee findbyId(int id);
	public ArrayList<Employee> getAllEmployees();
	
	
}
