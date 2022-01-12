package com.komal.springbootApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.komal.springbootApp.model.Employee;

public class mainDemo {
	
	public static void main(String[] args)
	{
		List<Employee> lst = new ArrayList<Employee>();
		lst.add(new Employee(1,"komal","ER"));
		lst.add(new Employee(3,"nikhil","Java"));
		lst.add(new Employee(2,"hema","HR"));
		lst.add(new Employee(4,"ganesh","HM"));
		
		//List<Employee> empSorted = lst.stream().sorted((o1,o2)-> (o2.getId()-o1.getId())).collect(Collectors.toList());
		List<Employee> empSorted = lst.stream().sorted(new NameComparator()).collect(Collectors.toList());
		
		for(Employee emp : empSorted)
		{
			System.out.println(emp);
		}
	}

}
