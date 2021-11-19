package com.tcs.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.Employee;
import com.tcs.repo.EmployeeRepository;
import com.tcs.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee emp) {
		repo.save(emp);
		return emp.getEid();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteOneEmployee(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Employee editOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		Employee e = null;
		if(opt.isPresent())
			e = opt.get();
		return e;
	}
}
