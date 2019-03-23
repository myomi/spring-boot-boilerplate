package com.example.springbootboilerplate.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootboilerplate.dao.EmployeesDao;
import com.example.springbootboilerplate.entity.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeesDao dao;
	
	public EmployeeController(EmployeesDao dao) {
		this.dao = dao;
	}

	@GetMapping("/{employeeId}")
	public Employees get(@PathVariable("employeeId") Long employeeId) {
		return this.dao.selectById(employeeId);
	}
}
