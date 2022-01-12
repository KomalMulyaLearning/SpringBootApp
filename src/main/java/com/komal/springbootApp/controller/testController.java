package com.komal.springbootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komal.springbootApp.custom.exception.BusinessException;
import com.komal.springbootApp.custom.exception.ControllerException;
import com.komal.springbootApp.dao.EmployeeRepository;
import com.komal.springbootApp.model.Employee;
import com.komal.springbootApp.services.EmployeeService;

@RestController
@RequestMapping("/test")
public class testController {
	
	@Autowired
	EmployeeService employeeService ; 

	/*@PostMapping(value= "saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}*/
	/*Custom Exception Handling
	@PostMapping(value= "saveEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{
		try
		{
			Employee empSaved = employeeService.saveEmployee(employee);
			return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
		}
		catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("611", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	} */
	
	@PostMapping(value= "saveEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{

		Employee empSaved = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
	}
	
	@GetMapping(value= "getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> empGetAll = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empGetAll, HttpStatus.OK);
	}
	
	@GetMapping(value= "getEmployeeByID/{id}")
	public ResponseEntity<?> getEmployeeByID(@PathVariable int id)
	{
		try
		{
			Employee empReturned = employeeService.getEmployeeByID(id);
			return new ResponseEntity<Employee>(empReturned, HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("612", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value= "getEmployeeByDept/{dept}")
	public List<Employee> getEmployeeByDept(@PathVariable String dept)
	{
		return employeeService.getEmployeeByDept(dept);
	}
	
	@DeleteMapping(value="deleteEmployeeByID/{id}")
	public ResponseEntity<Void> deleteEmployeeByID(@PathVariable int id)
	{
		employeeService.deleteEmployeeByID(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	@PutMapping(value= "updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee empSaved = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
	}

}
