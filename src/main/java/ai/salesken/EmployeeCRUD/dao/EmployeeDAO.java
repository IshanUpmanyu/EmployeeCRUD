package ai.salesken.EmployeeCRUD.dao;

import ai.salesken.EmployeeCRUD.exception.EmployeeNotFoundException;
import ai.salesken.EmployeeCRUD.model.Employee;

public interface EmployeeDAO {
	
	/**
	 * Adds the employee to the repository
	 *
	 * @param e the employee to add
	 * @return the id of the employee added
	 */
	public long addEmployee(Employee e); 
	
	/**
	 * Delete employee with the given id.
	 *
	 * @param employeeId the id of the employee to delete
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	public void deleteEmployee(long employeeId) throws EmployeeNotFoundException;
	
	/**
	 * Update an existing employee.
	 *
	 * @param e the updated employee object
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	public void updateEmployee(Employee e) throws EmployeeNotFoundException;
	
	/**
	 * Gets the employee with given id
	 *
	 * @param employeeId the id of the employee to find
	 * @return the employee object with given id
	 * @throws EmployeeNotFoundException the employee not found exception
	 */
	public Employee getEmployee(long employeeId)throws EmployeeNotFoundException;
}
