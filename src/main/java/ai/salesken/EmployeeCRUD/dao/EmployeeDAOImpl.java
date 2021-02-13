/**
 * 
 */
package ai.salesken.EmployeeCRUD.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import ai.salesken.EmployeeCRUD.exception.EmployeeNotFoundException;
import ai.salesken.EmployeeCRUD.model.Employee;

/**
 * @author Ishan Upamanyu
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	/** The id of the last employee. */
	long lastEmployeeId;
	
	/** The employee repository storing all employee objects */
	Map<Long, Employee> employeeRepository;
	
	/**
	 * Instantiates a new employee DAO impl object.
	 */
	public EmployeeDAOImpl() {
		lastEmployeeId = 0;
		employeeRepository = new ConcurrentHashMap<>();
	}

	@Override
	public synchronized long addEmployee(Employee e) {
		e.setEmployeeId(++lastEmployeeId);
		employeeRepository.put(lastEmployeeId, e);
		return lastEmployeeId;
	}

	@Override
	public void deleteEmployee(long employeeId) throws EmployeeNotFoundException {
		employeeRepository.remove(employeeId);
	}

	@Override
	public void updateEmployee(Employee e) throws EmployeeNotFoundException {
		employeeRepository.put(e.getEmployeeId(), e);
	}

	@Override
	public Employee getEmployee(long employeeId) throws EmployeeNotFoundException {
		if( employeeRepository.get(employeeId)== null) {
			throw new EmployeeNotFoundException(employeeId);
		}
		return employeeRepository.get(employeeId);
	}

}
