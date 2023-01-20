package com.gl.employee.service;

import java.util.List;

import com.gl.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();

	Employee findEmployeeById(int id);

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(int id);

}