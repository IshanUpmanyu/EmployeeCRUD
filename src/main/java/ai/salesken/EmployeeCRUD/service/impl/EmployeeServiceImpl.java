package ai.salesken.EmployeeCRUD.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.salesken.EmployeeCRUD.dao.EmployeeDAO;
import ai.salesken.EmployeeCRUD.exception.EmployeeNotFoundException;
import ai.salesken.EmployeeCRUD.model.Employee;
import ai.salesken.EmployeeCRUD.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** The employee DAO. */
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public long addEmployee(Employee e) {
		return employeeDAO.addEmployee(e);
	}

	@Override
	public void deleteEmployee(long employeeId) throws EmployeeNotFoundException {
		employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public void updateEmployee(Employee e) throws EmployeeNotFoundException {
		employeeDAO.updateEmployee(e);
	}

	@Override
	public Employee getEmployee(long employeeId) throws EmployeeNotFoundException {
		return employeeDAO.getEmployee(employeeId);
	}

}
