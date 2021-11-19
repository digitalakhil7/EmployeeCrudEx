package com.tcs.service;

import java.util.List;

import com.tcs.entity.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public void deleteOneEmployee(Integer id);
	public Employee editOneEmployee(Integer id);
}
