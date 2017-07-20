package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.ITenantDao;
import entity.Address;
import entity.Tenant;
import util.UtilDB;

public class TenantDBDao implements ITenantDao {

	private static final Logger logger = Logger.getLogger(TeamMemberDBDao.class);
	private static final TenantDBDao TENANT_DB_DAO = new TenantDBDao();
	
	private TenantDBDao() {
		
	}
	
	public static TenantDBDao getInstance() {
		return TENANT_DB_DAO;
	}
	
	@Override
	public void add(Tenant tenant) {
		
		String sql = "INSERT INTO Tenant (Adress_ID, Full_name, Login, Password) VALUES(?, ?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, tenant.getAddressId());
            statement.setString(2, tenant.getFullName());
            statement.setString(3, tenant.getLogin());
            statement.setString(4, tenant.getPassword());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Tenant> getAll() {
		
		List<Tenant> resultList = new ArrayList<>();
		
		String sql = "SELECT Tenant_ID, Address_ID, Full_name, Login, Password FROM Tenant";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Tenant tenant = new Tenant(resultSet.getLong("Tenant_ID"),
	            		 					resultSet.getLong("Address_ID"),
	            		 					resultSet.getString("Full_name"),
	            		 					resultSet.getString("Login"),
	            		 					resultSet.getString("Password"));
	           
	             resultList.add(tenant);
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
	public Tenant getById(Long id) {
		
		Tenant tenant = new Tenant();
		String sql = "SELECT Tenant_ID, Address_ID, Full_name, Login, Password FROM Tenant WHERE Tenant_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();

			 resultSet.next();
	         tenant.setId(resultSet.getLong("Tenant_ID"));
	         tenant.setAddressId(resultSet.getLong("Address_ID"));
 			 tenant.setFullName(resultSet.getString("Full_name"));
 			 tenant.setLogin(resultSet.getString("Login"));
		 	 tenant.setPassword(resultSet.getString("Password"));
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return tenant;
	}

	@Override
	public void update(Tenant tenant) {
		
		String sql = "UPDATE Tenant SET Address_ID=?, Full_name=?, Login=?, Password=? WHERE Tenant_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, tenant.getAddressId());
            statement.setString(2, tenant.getFullName());
            statement.setString(3, tenant.getLogin());
            statement.setString(4, tenant.getPassword());
            statement.setLong(5, tenant.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Tenant tenant) {
		
		String sql = "DELETE FROM Tenant WHERE Tenant_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, tenant.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public Tenant getTenantByAdress(Address address) {
		
		Tenant tenant = new Tenant();
		String sql = "SELECT Tenant_ID, Address_ID, Full_name, Login, Password FROM Tenant WHERE Address_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, address.getId());
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         tenant.setId(resultSet.getLong("Tenant_ID"));
	         tenant.setAddressId(resultSet.getLong("Address_ID"));
 			 tenant.setFullName(resultSet.getString("Full_name"));
 			 tenant.setLogin(resultSet.getString("Login"));
		 	 tenant.setPassword(resultSet.getString("Password"));
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return tenant;
	}

	@Override
	public Tenant getTenantByLogin(String login) {
		
		Tenant tenant = new Tenant();
		String sql = "SELECT Tenant_ID, Address_ID, Full_name, Login, Password FROM Tenant WHERE Login=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setString(1, login);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         tenant.setId(resultSet.getLong("Tenant_ID"));
	         tenant.setAddressId(resultSet.getLong("Address_ID"));
 			 tenant.setFullName(resultSet.getString("Full_name"));
 			 tenant.setLogin(resultSet.getString("Login"));
		 	 tenant.setPassword(resultSet.getString("Password"));
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return tenant;
	}

}
