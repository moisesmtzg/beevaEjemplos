package com.beeva.implementacion;

import java.util.ArrayList;

import com.beeva.DAOStore.EmpleadosArray;
import com.beeva.Model.Employee;
import com.beeva.interfaces.EmployeeInterface;

public class EmployeeDAOImplArray implements EmployeeInterface{

	public boolean addEmployee(Employee empleado) {
		EmpleadosArray empleados= new EmpleadosArray();
		empleados.listaEmpleados.add(empleado);
		return true;
	}

	public boolean updateEmployee(Employee empleado) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployee(int numEmpleado) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee findbyId(int id) {
		EmpleadosArray empleados= new EmpleadosArray();
		return empleados.listaEmpleados.get(id);
	}

	public ArrayList<Employee> getAllEmployees() {
		EmpleadosArray empleados= new EmpleadosArray();
		return empleados.listaEmpleados;
	}

}
