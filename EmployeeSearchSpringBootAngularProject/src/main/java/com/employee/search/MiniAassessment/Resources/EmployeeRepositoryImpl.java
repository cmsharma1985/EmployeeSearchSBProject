package com.employee.search.MiniAassessment.Resources;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.search.MiniAassessment.Model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> search(String keyword, SearchDirection searchDirection) {
		Query query = entityManager.createQuery("from Employee where name like : keyword");
		if (searchDirection == SearchDirection.Begins) {
			query.setParameter("keyword", keyword + "%");
		} else if (searchDirection == SearchDirection.Contains) {
			query.setParameter("keyword", "%" + keyword + "%");
		} else if (searchDirection == SearchDirection.End) {
			query.setParameter("keyword", "%" + keyword);
		}
		return query.getResultList();
	}

	@Override
	public List<Employee> between(Date start_date, Date end_date) {
		Query query = entityManager.createQuery("from Employee where joiningdate between : start_date and : end_date");	
		query.setParameter("start_date", start_date);
		query.setParameter("end_date", end_date);
		return query.getResultList();	
		}

	@Override
	public List<Employee> search(String keyword) {
		Query query = entityManager.createQuery("from Employee where firstname like : keyword or lastname like : keyword");
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();
	}

	@Override
	public List<Employee> getAllEmployee() {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

}
