package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepo repo;
	private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeService.class);


	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.repo = employeeRepo;
	}
	
	public Employee addEmp(Employee employee) {
		LOGGER.info("Received employee from post request - " + employee);

		employee.setEmpCode(UUID.randomUUID().toString());
		return repo.save(employee);
	}
	
	public Employee findEmp(Long id) {
		return repo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));
	}
	public List<Employee> findAll(){
		return repo.findAll();
	}
	public Employee updateEmp(Employee emp) {
		return repo.save(emp);
	}
	public void deleteEmp(Long id) {
		 repo.deleteEmployeeById(id);
	}
	
	
	

}
