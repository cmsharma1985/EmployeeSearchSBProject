package com.employee.search.MiniAassessment.Resources;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.search.MiniAassessment.Model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee, String>, EmployeeRepositoryCustom {

}
