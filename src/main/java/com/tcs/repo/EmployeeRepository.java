package com.tcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
