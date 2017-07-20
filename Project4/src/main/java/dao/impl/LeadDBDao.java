package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.ILeadDao;
import entity.Lead;
import entity.Specialization;
import util.UtilDB;

public class LeadDBDao implements ILeadDao {

	private static final Logger logger = Logger.getLogger(LeadDBDao.class);
	private static final LeadDBDao LEAD_DB_DAO = new LeadDBDao();
	
	private LeadDBDao() {
		
	}
	
	public static LeadDBDao getInstance() {
		return LEAD_DB_DAO;
	}
	
	@Override
	public void add(Lead lead){
		
		String sql = "INSERT INTO Lead (Specialization_ID, Full_name, Phone_number) VALUES(?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, lead.getSpecializationId());
            statement.setString(2, lead.getFullName());
            statement.setString(3, lead.getPhoneNumber());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Lead> getAll(){

		List<Lead> resultList = new ArrayList<>();
		
		String sql = "SELECT Lead_ID, Specialization_ID, Full_name, Phone_number FROM Lead";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Lead lead = new Lead();
	             lead.setId(resultSet.getLong("Lead_ID"));
	             lead.setSpecializationId(resultSet.getLong("Specialization_ID"));
	             lead.setFullName(resultSet.getString("Full_name"));
	             lead.setPhoneNumber(resultSet.getString("Phone_number"));
	           
	             resultList.add(lead);
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
	public Lead getById(Long id){
		
		Lead lead = new Lead();
		String sql = "SELECT Lead_ID, Specialization_ID, Full_name, Phone_number FROM Lead WHERE Lead_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
             lead.setId(resultSet.getLong("Lead_ID"));
             lead.setSpecializationId(resultSet.getLong("Specialization_ID"));
             lead.setFullName(resultSet.getString("Full_name"));
             lead.setPhoneNumber(resultSet.getString("Phone_number"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return lead;
	}

	@Override
	public void update(Lead lead){

		String sql = "UPDATE Lead SET Specialization_ID=?, Full_name=?, Phone_number=? WHERE Lead_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
				 PreparedStatement statement = connection.prepareStatement(sql)) {
				
            statement.setLong(1, lead.getSpecializationId());
            statement.setString(2, lead.getFullName());
            statement.setString(3, lead.getPhoneNumber());
	        statement.setLong(4, lead.getId());
	            
	        statement.executeUpdate();
			} catch (SQLException e){
				logger.error(e);
			}
	}

	@Override
	public void remove(Lead lead){
		
		String sql = "DELETE FROM Lead WHERE Lead_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, lead.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Lead> getLeadsBySpecialization(Specialization specialization) {

		List<Lead> resultList = new ArrayList<>();
		
		String sql = "SELECT Lead_ID, Specialization_ID, Full_name, Phone_number "
				+ "FROM Lead WHERE Specialization_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setLong(1, specialization.getId());
			ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Lead lead = new Lead();
	            lead.setId(resultSet.getLong("Lead_ID"));
	            lead.setSpecializationId(resultSet.getLong("Specialization_ID"));
	            lead.setFullName(resultSet.getString("Full_name"));
	            lead.setPhoneNumber(resultSet.getString("Phone_number"));
	          
	            resultList.add(lead);
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
