package com.example.employee.convertor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.entity.Groups;
import com.example.employee.entity.Position;

@Component
public class EmployeeConvertor {
	public Employee convertor(EmployeeDto employeeDto) {
		Employee employee=new Employee();
		Department department=new Department();
		Position position=new Position();
//		employee.setDepartment(department);
		employee.setPosition(position);
		position.setId(employeeDto.getPosition());
		department.setId(employeeDto.getDepartment());
		employee.setEmail(employeeDto.getEmail());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setJobTitle(employeeDto.getJobTitle());
		employee.setPhone(employeeDto.getPhone());
		employee.setSex(employeeDto.getSex());
		employee.setAddress(employeeDto.getAddress());
		Set<Groups> listGroups=new HashSet<>();
		employeeDto.getGroups().stream().forEach(groupsDto->{
			Groups groups=new Groups();
			groups.setEmployee(employee);
			groups.setName(groupsDto.getName());
			groups.setCreateDate(new Timestamp(System.currentTimeMillis()));
			listGroups.add(groups);
		});
//		employee.setGroups(listGroups);
		return employee;
	}
}
