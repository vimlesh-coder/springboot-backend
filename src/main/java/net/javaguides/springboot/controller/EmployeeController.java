package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employees;
import net.javaguides.springboot.service.EmployeeService;
import org.hibernate.dialect.temptable.TemporaryTableKind;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;


	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	//build create employee Rest API
	@PostMapping()
	public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employee) {

		return new ResponseEntity<Employees>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

//build get all employees rest api

	@GetMapping
	public List<Employees> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// build get employees by iid Rest Api
	//http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employees> getEmployeesById(@PathVariable("id") long employeeId) {

		return new ResponseEntity<Employees>(employeeService.getEmployeesById(employeeId), HttpStatus.OK);
	}


	// build update emploee RestApi
//http://localhost:8080/api/employees/1
	@PutMapping()
	public ResponseEntity<String> updateEmployees( @RequestBody Employees employee)
		{
//			return new ResponseEntity<Employees>(employeeService.updateEmployees(employee, id), HttpStatus.OK);
		Boolean updatedEmp = employeeService.updateEmployees(employee);
		return new ResponseEntity<>("Updated Success", HttpStatus.OK);
		}
		//build delete employee rest api

	@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployees(@PathVariable("id") long id){
//delete employee from db
employeeService.deleteEmployees(id);

return new ResponseEntity<>("Emplyees deleted successfully!.",HttpStatus.OK);

}
}