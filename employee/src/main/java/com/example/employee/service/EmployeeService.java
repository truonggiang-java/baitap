package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeService {
	void insert(Employee e);
	void update(Employee e);
	Employee findById(Integer id);
	List<Employee> findAllEmployee();
}
