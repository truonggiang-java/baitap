package com.example.employee.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.convertor.EmployeeConvertor;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import com.sun.mail.iap.Response;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeSevice;
	
	@Autowired
	private EmployeeConvertor employeeConvertor;
	
	@PostMapping("/employee")
	private ResponseEntity<Object> insert(@Valid @RequestBody EmployeeDto employeeDto,Errors errors){
		if(errors.hasErrors()) {
			return new ResponseEntity<>(errors.getAllErrors().stream().map(objectErrors -> objectErrors.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
		}
		Employee employee=employeeConvertor.convertor(employeeDto);
		employeeSevice.insert(employee);
		return new ResponseEntity<>("Thêm mới sản phẩm thành công",HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	private ResponseEntity<Object> findAllEmployee(){
		return new ResponseEntity<>(employeeSevice.findAllEmployee(),HttpStatus.OK);
	}
}
