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

import com.example.employee.entity.Employee;
import com.example.employee.entity.Position;
import com.example.employee.repository.PositionRepository;

@Repository
public class PositionRepositoryImpl implements PositionRepository{
	private SessionFactory sessionFactory;

	@Autowired
	public PositionRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void insert(Position p) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void update(Position p) {
		Session session=sessionFactory.getCurrentSession();
		session.update(p);
		
	}

	@Override
	public Position findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(Position.class, id);
	}

	@Override
	public List<Position> findAllPosition() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Position p join p.employee e";
		Query query =session.createQuery(hql);
		List<Position> listResult=query.list(); 
//		listResult.stream().forEach(res->{
//			System.out.println(res.getName());
//		});
		return listResult;
	}
	
	
}
