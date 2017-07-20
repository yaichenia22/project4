package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IRequestDao;
import entity.KindOfWork;
import entity.Request;
import entity.Tenant;
import util.UtilDB;

public class RequestDBDao implements IRequestDao {

	private static final Logger logger = Logger.getLogger(RequestDBDao.class);
	private static final RequestDBDao REQUEST_DB_DAO = new RequestDBDao();
	
	private RequestDBDao() {
		
	}
	
	public static RequestDBDao getInstance() {
		return REQUEST_DB_DAO;
	}
	
	@Override
	public void add(Request request) {

		String sql = "INSERT INTO Request (Tenant_ID, Kind_ID, Scope_of_work,"
				+ " Desired_execute_date, Application_date, Comment) VALUES(?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, request.getTenantId());
            statement.setLong(2, request.getKindOfWorkId());
            statement.setString(3, request.getScopeOfWork());
            statement.setTimestamp(4, request.getDesiredExecutionDate());
            statement.setTimestamp(5, request.getApplicationDate());
            statement.setString(6, request.getComment());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
		
	}

	@Override
	public List<Request> getAll() {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT Request_ID, Tenant_ID, Kind_ID, Scope_of_work, Desired_execute_date,"
				+ " Application_date, Comment FROM Request";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("Request_ID"),
	            		 						resultSet.getLong("Tenant_ID"),
	            		 						resultSet.getLong("Kind_ID"),
	            		 						resultSet.getString("Scope_of_work"),
	            		 						resultSet.getTimestamp("Desired_execute_date"),
	            		 						resultSet.getTimestamp("Application_date"),
	            		 						resultSet.getString("Comment"));
	           
	             resultList.add(request);
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
	public Request getById(Long id) {
		
		Request request = new Request();
		String sql = "SELECT Request_ID, Tenant_ID, Kind_ID, Scope_of_work, Desired_execute_date,"
				+ " Application_date, Comment FROM Request WHERE Request_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 request.setId(resultSet.getLong("Request_ID"));
			 request.setTenantId(resultSet.getLong("Tenant_ID"));
			 request.setKindOfWorkId(resultSet.getLong("Kind_ID"));
			 request.setScopeOfWork(resultSet.getString("Scope_of_work"));
			 request.setDesiredExecutionDate(resultSet.getTimestamp("Desired_execute_date"));
			 request.setApplicationDate(resultSet.getTimestamp("Application_date"));
			 request.setComment(resultSet.getString("Comment"));
			 
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return request;
	}

	@Override
	public void update(Request request) {
	
		String sql = "UPDATE Request SET Tenant_ID=?, Kind_ID=?, Scope_of_work=?, Desired_execute_date=?,"
				+ " Application_date=?, Comment=? WHERE Request_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, request.getTenantId());
            statement.setLong(2, request.getKindOfWorkId());
            statement.setString(3, request.getScopeOfWork());
            statement.setTimestamp(4, request.getDesiredExecutionDate());
            statement.setTimestamp(5, request.getApplicationDate());
            statement.setString(6, request.getComment());
            statement.setLong(7, request.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(Request request) {
		
		String sql = "DELETE FROM Request WHERE Request_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, request.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<Request> getAllRequestsFromTenant(Tenant tenant) {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT Request_ID, Tenant_ID, Kind_ID, Scope_of_work, Desired_execute_date,"
				+ " Application_date, Comment FROM Request WHERE Tenant_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, tenant.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("Request_ID"),
	            		 						resultSet.getLong("Tenant_ID"),
	            		 						resultSet.getLong("Kind_ID"),
	            		 						resultSet.getString("Scope_of_work"),
	            		 						resultSet.getTimestamp("Desired_execute_date"),
	            		 						resultSet.getTimestamp("Application_date"),
	            		 						resultSet.getString("Comment"));
	           
	             resultList.add(request);
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
	public List<Request> getAllRequestsOfKindWork(KindOfWork kindOfWork) {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT Request_ID, Tenant_ID, Kind_ID, Scope_of_work, Desired_execute_date,"
				+ " Application_date, Comment FROM Request WHERE Kind_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, kindOfWork.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("Request_ID"),
	            		 						resultSet.getLong("Tenant_ID"),
	            		 						resultSet.getLong("Kind_ID"),
	            		 						resultSet.getString("Scope_of_work"),
	            		 						resultSet.getTimestamp("Desired_execute_date"),
	            		 						resultSet.getTimestamp("Application_date"),
	            		 						resultSet.getString("Comment"));
	           
	             resultList.add(request);
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
	public List<Request> getAllUnconsideredRequests() {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT r.Request_ID, r.Tenant_ID, r.Kind_ID, r.Scope_of_work, r.Desired_execute_date,"
				+ " r.Application_date, r.Comment FROM Request r LEFT OUTER JOIN Working_plan w ON r.Request_ID "
				+ "= w.Request_ID WHERE w.Request_ID IS NULL";
		
		try (Connection connection = UtilDB.getConnection();
				Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("r.Request_ID"),
	            		 						resultSet.getLong("r.Tenant_ID"),
	            		 						resultSet.getLong("r.Kind_ID"),
	            		 						resultSet.getString("r.Scope_of_work"),
	            		 						resultSet.getTimestamp("r.Desired_execute_date"),
	            		 						resultSet.getTimestamp("r.Application_date"),
	            		 						resultSet.getString("r.Comment"));
	           
	             resultList.add(request);
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
	public List<Request> getConsideredRequestsOfTenant(Tenant tenant) {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT r.Request_ID, r.Tenant_ID, r.Kind_ID, r.Scope_of_work, r.Desired_execute_date,"
				+ " r.Application_date, r.Comment FROM Request r LEFT OUTER JOIN Working_plan w ON r.Request_ID "
				+ "= w.Request_ID WHERE w.Request_ID IS NOT NULL AND r.Tenant_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, tenant.getId());
			 
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("r.Request_ID"),
	            		 						resultSet.getLong("r.Tenant_ID"),
	            		 						resultSet.getLong("r.Kind_ID"),
	            		 						resultSet.getString("r.Scope_of_work"),
	            		 						resultSet.getTimestamp("r.Desired_execute_date"),
	            		 						resultSet.getTimestamp("r.Application_date"),
	            		 						resultSet.getString("r.Comment"));
	           
	             resultList.add(request);
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
	
	public List<Request> getDoneRequests() {
		
		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT r.Request_ID, r.Tenant_ID, r.Kind_ID, r.Scope_of_work, r.Desired_execute_date,"
				+ " r.Application_date, r.Comment FROM Request r LEFT OUTER JOIN Working_plan w ON r.Request_ID "
				+ "= w.Request_ID WHERE w.Request_ID IS NOT NULL AND CURRENT_TIMESTAMP()>w.Estimated_execute_date";
		
		try (Connection connection = UtilDB.getConnection();
				Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("r.Request_ID"),
	            		 						resultSet.getLong("r.Tenant_ID"),
	            		 						resultSet.getLong("r.Kind_ID"),
	            		 						resultSet.getString("r.Scope_of_work"),
	            		 						resultSet.getTimestamp("r.Desired_execute_date"),
	            		 						resultSet.getTimestamp("r.Application_date"),
	            		 						resultSet.getString("r.Comment"));
	           
	             resultList.add(request);
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
	public List<Request> getAllRequestsInProgress() {

		List<Request> resultList = new ArrayList<>();
		
		String sql = "SELECT r.Request_ID, r.Tenant_ID, r.Kind_ID, r.Scope_of_work, "
				+ "r.Desired_execute_date, r.Application_date, r.Comment FROM Request r "
				+ "LEFT OUTER JOIN Working_plan w ON r.Request_ID = w.Request_ID WHERE w.Request_ID "
				+ "IS NOT NULL AND CURRENT_TIMESTAMP()<w.Estimated_execute_date";
		
		try (Connection connection = UtilDB.getConnection();
				Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             Request request = new Request(	resultSet.getLong("r.Request_ID"),
	            		 						resultSet.getLong("r.Tenant_ID"),
	            		 						resultSet.getLong("r.Kind_ID"),
	            		 						resultSet.getString("r.Scope_of_work"),
	            		 						resultSet.getTimestamp("r.Desired_execute_date"),
	            		 						resultSet.getTimestamp("r.Application_date"),
	            		 						resultSet.getString("r.Comment"));
	           
	             resultList.add(request);
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
