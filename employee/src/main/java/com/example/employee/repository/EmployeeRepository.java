package com.example.employee.repository;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeRepository {
	void insert(Employee e);
	void update(Employee e);
	Employee findById(Integer id);
	List<Employee> findAllEmployees();
}
