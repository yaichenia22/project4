package service;

import java.util.List;

import dao.impl.DaoDBFactory;
import dao.interfaces.IEmployeeDao;
import entity.Employee;
import entity.Specialization;

public class EmployeeService {

	private static EmployeeService employeeService = null;
	private static IEmployeeDao employeeDao = null;
	
	private EmployeeService() {
		employeeDao = DaoDBFactory.getInstance().getEmployeeDao();
	}
	
	public static EmployeeService getInstance() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
	
	public List<Employee> getBySpecialization(Specialization specialization) {
		return employeeDao.getAllbySpecialization(specialization);
	}
	
	public Employee getById(Long id) {
		return employeeDao.getById(id);
	}
}
