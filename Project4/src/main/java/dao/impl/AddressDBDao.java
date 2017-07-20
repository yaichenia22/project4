package dao.impl;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.IAddressDao;
import entity.Address;
import entity.Tenant;
import util.UtilDB;

public class AddressDBDao implements IAddressDao {
	
	private static final Logger logger = Logger.getLogger(AddressDBDao.class);
	private static final AddressDBDao ADDRESS_DB_DAO = new AddressDBDao();
	
	private AddressDBDao() {

	}
	
	public static AddressDBDao getInstance(){
		return ADDRESS_DB_DAO;
	}
	
	@Override
	public void add(Address address) {
		
		String sql = "INSERT INTO Address (Street, House_number, Flat_number) VALUES(?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, address.getStreet());
            statement.setInt(2, address.getHouseNumber());
            statement.setInt(3, address.getFlatNumber());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Address> getAll() {
		
		List<Address> resultList = new ArrayList<>();
		
		String sql = "SELECT Address_ID, Street, House_number, Flat_number FROM Address";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Address address = new Address();
	             address.setId(resultSet.getLong("Address_ID"));
	             address.setStreet(resultSet.getString("Street"));
	             address.setHouseNumber(resultSet.getInt("House_number"));
	             address.setFlatNumber(resultSet.getInt("Flat_number"));
	           
	             resultList.add(address);
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
	public Address getById(Long id) {

		Address address = new Address();
		String sql = "SELECT Address_ID, Street, House_number, Flat_number FROM Address WHERE Address_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         address.setId(resultSet.getLong("Address_ID"));
	         address.setStreet(resultSet.getString("Street"));
	         address.setHouseNumber(resultSet.getInt("House_number"));
	         address.setFlatNumber(resultSet.getInt("Flat_number"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return address;
	}

	@Override
	public void update(Address address) {

		String sql = "UPDATE Address SET Street=?, House_number=?, Flat_number=? WHERE Address_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, address.getStreet());
            statement.setInt(2, address.getHouseNumber());
            statement.setInt(3, address.getFlatNumber());
            statement.setLong(4, address.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Address address) {

		String sql = "DELETE FROM Address WHERE Address_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, address.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Address> getFreeAdresses() {

		List<Address> resultList = new ArrayList<>();
		
		String sql = "SELECT a.Address_ID, a.Street, a.House_number, a.Flat_number FROM Address a "
				   + "LEFT OUTER JOIN Tenant t ON a.Address_ID = t.Address_ID WHERE t.Address_ID IS NULL";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Address address = new Address();
	             address.setId(resultSet.getLong("Address_ID"));
	             address.setStreet(resultSet.getString("Street"));
	             address.setHouseNumber(resultSet.getInt("House_number"));
	             address.setFlatNumber(resultSet.getInt("Flat_number"));
	           
	             resultList.add(address);
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
	public Address getAdressByTenant(Tenant tenant) {

		Address address = new Address();
		String sql = "SELECT a.Address_ID, a.Street, a.House_number, a.Flat_number FROM Address a "
				   + "WHERE a.Address_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, tenant.getId());
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         address.setId(resultSet.getLong("Address_ID"));
	         address.setStreet(resultSet.getString("Street"));
	         address.setHouseNumber(resultSet.getInt("House_number"));
	         address.setFlatNumber(resultSet.getInt("Flat_number"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return address;
	}
}