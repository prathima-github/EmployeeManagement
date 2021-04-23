package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {



	private final EmployeeService employeeService;
	private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getAllEmployee(@PathVariable Long id){
		return new ResponseEntity<>(employeeService.findEmp(id),HttpStatus.OK);	
		
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		LOGGER.info("Received employee from post request - " + emp);
		return new ResponseEntity<>(employeeService.addEmp(emp),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		return new ResponseEntity<>(employeeService.updateEmp(emp),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmp(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}
