package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.ISpecializationDao;
import entity.Specialization;
import util.UtilDB;

public class SpecializationDBDao implements ISpecializationDao {

	private static final Logger logger = Logger.getLogger(SpecializationDBDao.class);
	private static final SpecializationDBDao SPECIALIZATION_DB_DAO = new SpecializationDBDao();
	
	private SpecializationDBDao() {
		
	}
	
	public static SpecializationDBDao getInstance() {
		return SPECIALIZATION_DB_DAO;
	}
	
	@Override
	public void add(Specialization specialization) {

		String sql = "INSERT INTO Specialization (Specialization_name) VALUES(?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, specialization.getSpecializationName());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Specialization> getAll() {

		List<Specialization> resultList = new ArrayList<>();
		
		String sql = "SELECT Specialization_ID, Specialization_name FROM Specialization";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Specialization specialization 
	             = new Specialization(resultSet.getLong("Specialization_ID"),
	            		 			  resultSet.getString("Specialization_name"));
	           
	             resultList.add(specialization);
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
	public Specialization getById(Long id) {
		
		Specialization specialization = new Specialization();
		String sql = "SELECT Specialization_ID, Specialization_name FROM Specialization"
				+ " WHERE Specialization_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 specialization.setId(resultSet.getLong("Specialization_ID"));
			 specialization.setSpecializationName(resultSet.getString("Specializqtion_name"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return specialization;
	}

	@Override
	public void update(Specialization specialization) {
	
		String sql = "UPDATE Specialization SET Specialization_name=? WHERE Specialization_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, specialization.getSpecializationName());
            statement.setLong(2, specialization.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Specialization specialization) {
		
		String sql = "DELETE FROM Specialization WHERE Specialization_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, specialization.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public Specialization getByName(String name) {
		
		Specialization specialization = new Specialization();
		String sql = "SELECT Specialization_ID, Specialization_name FROM Specialization"
				+ " WHERE Specialization_name=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setString(1, name);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 specialization.setId(resultSet.getLong("Specialization_ID"));
			 specialization.setSpecializationName(resultSet.getString("Specialization_name"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return specialization;
	}
}
