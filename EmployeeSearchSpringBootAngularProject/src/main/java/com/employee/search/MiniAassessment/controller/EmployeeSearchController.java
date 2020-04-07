package com.employee.search.MiniAassessment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.search.MiniAassessment.Model.Employee;
import com.employee.search.MiniAassessment.Services.EmpolyeeSearchService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeSearchController {

	@Autowired
	EmpolyeeSearchService empolyeeSearchService;

	@PostMapping(value = "/employee/add")
	public void addEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getAge() + " " + emp.getFirstname() + " " + emp.getId() + emp.getLastname() + " "
				+ emp.getTitle() + " " + emp);
		empolyeeSearchService.addEmployee(emp);
	}

	@PutMapping(value = "/employee/update")
	public void updateEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getAge() + " " + emp.getFirstname() + " " + emp.getId() + emp.getLastname() + " "
				+ emp.getTitle() + " " + emp);
		empolyeeSearchService.updateEmployee(emp);
	}

	@PutMapping(value = "/employee/update/{id}")
	public void updateEmployeeByID(@RequestBody Employee emp, @PathVariable String id) {
		System.out.println(emp.getAge() + " " + emp.getFirstname() + " " + emp.getId() + emp.getLastname() + " "
				+ emp.getTitle() + " " + emp.getJoiningdate());
		empolyeeSearchService.updateEmployeeByID(emp, id);
	}

	@GetMapping(value = "/employee/servePeriod/{start_date}/{end_date}")
	public List<Employee> getAllEmployeeByServePeriod(
			@PathVariable("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
			@PathVariable("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date) {
		return empolyeeSearchService.getAllEmployeeByServePeriod(start_date, end_date);
	}

	@GetMapping(value = "/employee/name/{keyword}")
	public List<Employee> getAllEmployeeByName(@PathVariable String keyword) {
		return empolyeeSearchService.getAllEmployeeByName(keyword);
	}

	@GetMapping(value = "/employee/namebyid/{id}")
	public Employee getAllEmployeeById(@PathVariable String id) {
		return empolyeeSearchService.getAllEmployeeById(id);
	}

	@GetMapping(value = "/employee")
	public List<Employee> getAllEmployee() {
		return empolyeeSearchService.getAllEmployee();
	}

	@DeleteMapping(value = "/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable String id) {
		empolyeeSearchService.deleteEmployeeById(id);
	}
}
