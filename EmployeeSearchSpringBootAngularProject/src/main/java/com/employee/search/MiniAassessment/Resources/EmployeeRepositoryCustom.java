package com.employee.search.MiniAassessment.Resources;

import java.util.Date;
import java.util.List;

import com.employee.search.MiniAassessment.Model.Employee;

public interface EmployeeRepositoryCustom {

	enum SearchDirection {
		Begins, Contains, End
	}

	public List<Employee> search(String keyword, SearchDirection searchDirection);

	public List<Employee> search(String keyword);

	public List<Employee> between(Date start_date, Date end_date);
	
	public List<Employee> getAllEmployee();
	
}
