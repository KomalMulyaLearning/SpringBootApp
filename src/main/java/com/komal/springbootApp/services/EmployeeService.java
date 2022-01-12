package com.komal.springbootApp.services;

import java.util.List;

import com.komal.springbootApp.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeByID(int id);
	
	public List<Employee> getEmployeeByDept(String dept);
	
	public void deleteEmployeeByID(int id);

}
