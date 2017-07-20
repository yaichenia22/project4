package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IDispatcherDao;
import entity.Dispatcher;
import util.UtilDB;

public class DispatcherDBDao implements IDispatcherDao {

	private static final Logger logger = Logger.getLogger(DispatcherDBDao.class);
	private static final DispatcherDBDao DISPATCHER_DB_DAO = new DispatcherDBDao();
	
	private DispatcherDBDao() {
	
	}
	
	public static DispatcherDBDao getInstance() {
		return DISPATCHER_DB_DAO;
	}
	
	@Override
	public void add(Dispatcher dispatcher) {

		String sql = "INSERT INTO Dispatcher (Full_name, Phone_number, Login, Password) VALUES(?, ?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, dispatcher.getFullName());
            statement.setString(2, dispatcher.getPhoneNumber());
            statement.setString(3, dispatcher.getLogin());
            statement.setString(4, dispatcher.getPassword());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}

	}

	@Override
	public List<Dispatcher> getAll() {

		List<Dispatcher> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Dispatcher";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Dispatcher dispatcher = new Dispatcher();
	             dispatcher.setId(resultSet.getLong("Dispatcher_ID"));
	             dispatcher.setFullName(resultSet.getString("Full_name"));
	             dispatcher.setPhoneNumber(resultSet.getString("Phone_number"));
	             dispatcher.setLogin(resultSet.getString("Login"));
	             dispatcher.setPassword(resultSet.getString("Password"));
	           
	             resultList.add(dispatcher);
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
	public Dispatcher getById(Long id) {
		
		Dispatcher dispatcher = new Dispatcher();
		String sql = "SELECT * FROM Dispatcher WHERE Dispatcher_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 dispatcher.setId(resultSet.getLong("Dispatcher_ID"));
             dispatcher.setFullName(resultSet.getString("Full_name"));
             dispatcher.setPhoneNumber(resultSet.getString("Phone_number"));
             dispatcher.setLogin(resultSet.getString("Login"));
             dispatcher.setPassword(resultSet.getString("Password"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return dispatcher;
	}

	@Override
	public void update(Dispatcher dispatcher) {
		
		String sql = "UPDATE Dispatcher SET Full_name=?, Phone_number=?, Login=?, Password=? WHERE Dispatcher_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setString(1, dispatcher.getFullName());
            statement.setString(2, dispatcher.getPhoneNumber());
            statement.setString(3, dispatcher.getLogin());
            statement.setString(4, dispatcher.getPassword());
            statement.setLong(5, dispatcher.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Dispatcher dispatcher) {

		String sql = "DELETE FROM Dispatcher WHERE Dispatcher_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, dispatcher.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public Dispatcher getDispatcherByLogin(String login) {
		
		Dispatcher dispatcher = new Dispatcher();
		String sql = "SELECT * FROM Dispatcher WHERE Login=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setString(1, login);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 dispatcher.setId(resultSet.getLong("Dispatcher_ID"));
             dispatcher.setFullName(resultSet.getString("Full_name"));
             dispatcher.setPhoneNumber(resultSet.getString("Phone_number"));
             dispatcher.setLogin(resultSet.getString("Login"));
             dispatcher.setPassword(resultSet.getString("Password"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return dispatcher;
	}
}
