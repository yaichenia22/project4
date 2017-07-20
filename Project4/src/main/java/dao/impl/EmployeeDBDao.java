package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IEmployeeDao;
import entity.Employee;
import entity.Specialization;
import util.UtilDB;

public class EmployeeDBDao implements IEmployeeDao {

	private static final Logger logger = Logger.getLogger(EmployeeDBDao.class);
	private static final EmployeeDBDao EMPLOYEE_DB_DAO = new EmployeeDBDao();
	
	private EmployeeDBDao() {

	}
	
	public static EmployeeDBDao getInstance(){
		return EMPLOYEE_DB_DAO;
	}
	
	@Override
	public void add(Employee employee) {
		
		String sql = "INSERT INTO Employee (Full_name, Specialization_ID, Phone_number) VALUES(?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, employee.getFullName());
            statement.setLong(2, employee.getSpecializationId());
            statement.setString(3, employee.getPhoneNumber());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
		
	}

	@Override
	public List<Employee> getAll() {

		List<Employee> resultList = new ArrayList<>();
		
		String sql = "SELECT Employee_ID, Full_name, Specialization_ID, Phone_number FROM Employee";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Employee employee = new Employee();
	             employee.setId(resultSet.getLong("Employee_ID"));
	             employee.setFullName(resultSet.getString("Full_employee"));
	             employee.setSpecializationId(resultSet.getLong("Specialization_ID"));
	             employee.setPhoneNumber(resultSet.getString("Phone_number"));
	           
	             resultList.add(employee);
	            }
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return resultList;
	}

	@Override
	public Employee getById(Long id) {
		
		Employee employee = new Employee();
		String sql = "SELECT Employee_ID, Full_name, Specialization_ID, Phone_number FROM Employee WHERE Employee_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 employee.setId(resultSet.getLong("Employee_ID"));
             employee.setFullName(resultSet.getString("Full_employee"));
             employee.setSpecializationId(resultSet.getLong("Specialization_ID"));
             employee.setPhoneNumber(resultSet.getString("Phone_number"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return employee;
	}

	@Override
	public void update(Employee employee) {
		
		String sql = "UPDATE Employee SET Full_name=?, Specialization_ID=?, Phone_number=? WHERE Employee_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, employee.getFullName());
            statement.setLong(2, employee.getSpecializationId());
            statement.setString(3, employee.getPhoneNumber());
            statement.setLong(4, employee.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Employee employee) {
		
		String sql = "DELETE FROM Employee WHERE Employee_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, employee.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Employee> getAllbySpecialization(Specialization specialization) {

		List<Employee> resultList = new ArrayList<>();
		
		String sql = "SELECT Employee_ID, Full_name, Specialization_ID, "
				+ "Phone_number FROM Employee WHERE Specialization_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			 
			 statement.setLong(1, specialization.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             Employee employee = new Employee();
	             employee.setId(resultSet.getLong("Employee_ID"));
	             employee.setFullName(resultSet.getString("Full_name"));
	             employee.setSpecializationId(resultSet.getLong("Specialization_ID"));
	             employee.setPhoneNumber(resultSet.getString("Phone_number"));
	           
	             resultList.add(employee);
	            }
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return resultList;
	}
}
