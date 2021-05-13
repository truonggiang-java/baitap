package com.example.employee.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.entity.Groups;
import com.example.employee.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	private SessionFactory sessionFactory;
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Override
	public void insert(Employee e) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(e);
	}
	@Override
	public void update(Employee e) {
		Session session=sessionFactory.getCurrentSession();
		session.update(e);
	}
	@Override
	public Employee findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(Employee.class, id);
	}
	@Override
	public List<Employee> findAllEmployees() {
		Session session =sessionFactory.getCurrentSession();
		String hql="from Employee e inner join e.department d inner join e.position p";
		Query query =session.createQuery(hql);
		List<Employee> listResult=query.list();
		return listResult;
		
		
	}

}
