package com.gl.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.entity.Employee;
import com.gl.employee.repository.EmployeeRepository;
import com.gl.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployees() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Employee();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Optional<Employee> result = employeeRepository.findById(employee.getId());
		Employee existing = result.get();
		existing.setFirstName(employee.getFirstName());
		existing.setLastName(employee.getLastName());
		existing.setEmail(employee.getEmail());

		return employeeRepository.save(existing);

	}

	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
	}

}