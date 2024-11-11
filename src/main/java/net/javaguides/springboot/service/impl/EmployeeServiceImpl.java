package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employees;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employees saveEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Boolean updateEmployees(Employees employee) {
//we need to check whether eployee with given id exist in DB or not
 Employees existingEmployee=employeeRepository.findById(employee.getId()).orElseThrow(()->new ResourceNotFoundException("Employees","Id",employee.getId()));
 existingEmployee.setFirstName(employee.getFirstName());
 existingEmployee.setLastName(employee.getLastName());
 existingEmployee.setEmailVimlesh(employee.getEmailVimlesh());
 existingEmployee.setId(employee.getId());

 //save existing employee to DB
		employeeRepository.save(existingEmployee);
		return true;

		//return employeeRepository.save(employee) != null;
	}



	@Override
	public Employees getEmployeesById(long id) {
	/*	Optional<Employees> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employees", "Id", id);
		}
*/
		//this is lambda expression
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "Id", id));


	}

	// delete
	@Override
	public void deleteEmployees(long id) {

		//check whether a employee exist in a DB or mot

     employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employees","Id",id));

      employeeRepository.deleteById(id);



	}


}