package ai.salesken.EmployeeCRUD.exception;

public class EmployeeNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee not found exception.
	 *
	 * @param employeeId the employee id
	 */
	public EmployeeNotFoundException(long employeeId) {
		super("Employee not found with id: "+employeeId);
	}

}
