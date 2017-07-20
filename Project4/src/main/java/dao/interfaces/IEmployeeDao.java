package dao.interfaces;

import java.util.List;

import entity.Employee;
import entity.Specialization;

public interface IEmployeeDao extends IDao<Employee> {

	/*
	 * this method returns collection of employees by some specialization
	 */
	public List<Employee> getAllbySpecialization (Specialization specialization);
	
}
