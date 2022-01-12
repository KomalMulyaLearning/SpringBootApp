package com.komal.springbootApp.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komal.springbootApp.custom.exception.BusinessException;
import com.komal.springbootApp.custom.exception.EmptyInputException;
import com.komal.springbootApp.dao.EmployeeRepository;
import com.komal.springbootApp.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/* Custom Exception Handling
	@Override
	public Employee saveEmployee(Employee employee)
	{
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0)
		{
			throw new BusinessException("601","Name is blank");
		}
		try 
		{
			return employeeRepository.save(employee);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602","given employee is null"+e.getMessage());
		}
		catch (Exception e) {
			throw new BusinessException("603","something went wrong in service"+e.getMessage());
		}
	}
	*/
	@Override
	public Employee saveEmployee(Employee employee)
	{
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0)
		{
			throw new EmptyInputException("601","Name is blank");
		}
			return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee()
	{
		List<Employee> emplist = null;
		try
		{
			emplist = employeeRepository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("605","something went wrong in service in getAllEmployee "+e.getMessage());
		}
		if(emplist.isEmpty())
			throw new BusinessException("604","List is empty");
		return emplist;
		
	}
	@Override
	public Employee getEmployeeByID(int id)
	{
		try
		{
			return employeeRepository.findById(id);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("606","given employee is null"+e.getMessage());
		}
		catch (NoSuchElementException e) {
			throw new BusinessException("607","given employee id doesn't exists in db"+e.getMessage());
		}
		catch (Exception e) {
			throw new BusinessException("609","something went wrong in service in getEmployeeByID "+e.getMessage());
		}
	}
	@Override
	public List<Employee> getEmployeeByDept(String dept) 
	{
		return employeeRepository.findByDept(dept);
	}
	@Override
	public void deleteEmployeeByID(int id) 
	{	
		try
		{
			employeeRepository.deleteById(id);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("608","given employee id is null"+e.getMessage());
		}
		catch (Exception e) {
			throw new BusinessException("609","something went wrong in service in deleteEmployeeByID "+e.getMessage());
		}
	}


}
