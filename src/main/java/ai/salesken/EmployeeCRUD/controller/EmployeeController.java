package ai.salesken.EmployeeCRUD.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.salesken.EmployeeCRUD.exception.EmployeeNotFoundException;
import ai.salesken.EmployeeCRUD.model.Employee;
import ai.salesken.EmployeeCRUD.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping("employe")
public class EmployeeController {
	
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Gets the employee with given id
	 *
	 * @param employeeId the employee id
	 * @return the employee
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	@GetMapping(value="/{employeeId}", produces = "application/json")
	public Employee getEmployee(@PathVariable long employeeId) throws EmployeeNotFoundException {
		return employeeService.getEmployee(employeeId);
	}
	
	/**
	 * Deletes employee with given id
	 *
	 * @param employeeId the employee id
	 * @return the map
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	@DeleteMapping(value="/{employeeId}", produces = "application/json")
	public Map<String, String> deleteEmployee(@PathVariable long employeeId) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(employeeId);
		return Collections.singletonMap("response", "Employee deleted with id: "+employeeId);
	}
	
	/**
	 * Adds the employee
	 *
	 * @param e the e
	 * @return the map
	 */
	@PostMapping(produces = "application/json")
	public Map<String, String> addEmployee(Employee e) {
		long employeeId = employeeService.addEmployee(e);
		return Collections.singletonMap("response", "Employee created with id: "+employeeId);
	}
	
	/**
	 * Updates the employee.
	 *
	 * @param e the e
	 * @return the map
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	@PutMapping(produces = "application/json")
	public Map<String, String> updateEmployee(Employee e) throws EmployeeNotFoundException {
		employeeService.updateEmployee(e);
		return Collections.singletonMap("response", "Employee updated with id: "+e.getEmployeeId());
	}
	
	
}
