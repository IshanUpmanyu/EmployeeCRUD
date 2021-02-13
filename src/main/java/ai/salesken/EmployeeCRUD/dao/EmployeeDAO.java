package ai.salesken.EmployeeCRUD.dao;

import ai.salesken.EmployeeCRUD.model.Employee;

public interface EmployeeDAO {
	
	/**
	 * Adds the employee to the repository
	 *
	 * @param e the employee to add
	 * @return the id of the employee added
	 */
	public int addEmployee(Employee e); 
}
