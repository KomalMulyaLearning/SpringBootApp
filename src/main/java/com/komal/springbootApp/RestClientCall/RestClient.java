package com.komal.springbootApp.RestClientCall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.komal.springbootApp.model.Employee;

public class RestClient {
	
	private static final String saveEmployee = "http://localhost:8085/test/saveEmployee";
	private static final String getAllEmployee = "http://localhost:8085/test/getAllEmployee";
	private static final String getEmployeeByID = "http://localhost:8085/test/getEmployeeByID/{id}";
	private static final String deleteEmployeeByID = "http://localhost:8085/test/deleteEmployeeByID/{id}";
	private static final String updateEmployee = "http://localhost:8085/test/updateEmployee";

	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args)
	{
		callGetAllEmployeeAPI();
		callGetEmployeeByIDAPI();
		callSaveEmployeeAPI();
		callUpdateEmployeeAPI();
		callDeleteEmployeeByIDAPI();
	}
	
	public static void callGetAllEmployeeAPI()
	{
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", header);
		ResponseEntity<List> response = restTemplate.exchange(getAllEmployee, HttpMethod.GET, entity, List.class );
		System.out.println(response.getBody().get(0));
		
		/*ResponseEntity<Employee> response = restTemplate.exchange(getAllEmployee, HttpMethod.GET, entity, Employee.class );
		System.out.println(response.getBody().getDept()); */
		
	}
	public static void callGetEmployeeByIDAPI()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 2);
		Employee emp = restTemplate.getForObject(getEmployeeByID, Employee.class, param);
		System.out.println(emp.getName());
		
	}
	
	public static void callSaveEmployeeAPI()
	{
		Employee emp = new Employee(4,"Tyty","java");
		ResponseEntity<Employee> response = restTemplate.postForEntity(saveEmployee, emp, Employee.class);
		System.out.println(response.getBody().getName());
		
	}
	
	public static void callUpdateEmployeeAPI()
	{
		Employee emp = new Employee(3,"rrrr","java");
		restTemplate.put(updateEmployee, emp, Employee.class);
		
	}
	public static void callDeleteEmployeeByIDAPI()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 2);
		restTemplate.delete(deleteEmployeeByID, param);		
	}
	
}
