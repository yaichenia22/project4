package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IWorkingPlanDao;
import entity.KindOfWork;
import entity.Request;
import entity.WorkingPlan;
import util.UtilDB;

public class WorkingPlanDBDao implements IWorkingPlanDao {

	private static final Logger logger = Logger.getLogger(WorkingPlanDBDao.class);
	private static final WorkingPlanDBDao WORKING_PLAN_DB_DAO = new WorkingPlanDBDao();
	
	private WorkingPlanDBDao() {
		
	}
	
	public static WorkingPlanDBDao getInstance() {
		
		return WORKING_PLAN_DB_DAO;
	}
	
	@Override
	public void add(WorkingPlan plan) {
		
		String sql = "INSERT INTO Working_Plan (Request_ID, Dispatcher_ID, Team_ID, "
				+ "Estimated_execute_date, Estimated_start_date, Comment) VALUES(?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, plan.getRequestId());
            statement.setLong(2, plan.getDispatcherId());
            statement.setLong(3, plan.getWorkTeamId());
            statement.setTimestamp(4, plan.getEstimatedExecutionDate());
            statement.setTimestamp(5, plan.getEstimatedStartDate());
            statement.setString(6, plan.getComment());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<WorkingPlan> getAll() {
		
		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Working_plan";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("Plan_ID"),
	            		 							resultSet.getLong("Request_ID"),
	            		 							resultSet.getLong("Dispatcher_ID"),
	            		 							resultSet.getLong("Team_ID"),
	            		 							resultSet.getTimestamp("Estimated_execute_date"),
	            		 							resultSet.getTimestamp("Estimated_start_date"),
	            		 							resultSet.getString("Comment"));
	           
	             resultList.add(plan);
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
	public WorkingPlan getById(Long id) {
		
		WorkingPlan plan = new WorkingPlan();
		String sql = "SELECT * FROM Working_plan WHERE Plan_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         plan.setId(resultSet.getLong("Plan_ID"));
	         plan.setRequestId(resultSet.getLong("Request_ID"));
	         plan.setDispatcherId(resultSet.getLong("Dispatcher_ID"));
	         plan.setWorkTeamId(resultSet.getLong("Team_ID"));
	         plan.setEstimatedExecutionDate(resultSet.getTimestamp("Estimated_execute_date"));
	         plan.setEstimatedStartDate(resultSet.getTimestamp("Estimated_start_date"));
	         plan.setComment(resultSet.getString("Comment"));
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return plan;
	}

	@Override
	public void update(WorkingPlan plan) {
		
		String sql = "UPDATE Working_plan SET Request_ID=?, Dispatcher_ID=?, Team_ID=?, "
				+ "Estimated_execute_date=?, Estimated_start_date, Comment=? WHERE Team_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, plan.getRequestId());
            statement.setLong(2, plan.getDispatcherId());
            statement.setLong(3, plan.getWorkTeamId());
            statement.setTimestamp(4, plan.getEstimatedExecutionDate());
            statement.setTimestamp(5, plan.getEstimatedStartDate());
            statement.setString(6, plan.getComment());
            statement.setLong(7, plan.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(WorkingPlan plan) {
		
		String sql = "DELETE FROM Working_plan WHERE Plan_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, plan.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<WorkingPlan> getPlansByExecuteDate(Timestamp executeDate) {
		
		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Working_plan WHERE "
				+ "(unix_timestamp(Estimated_execute_date)-unix_timestamp(?))<86400"
				+ " AND (unix_timestamp(Estimated_execute_date)-unix_timestamp(?))>0";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setTimestamp(1, executeDate);
			 statement.setTimestamp(2, executeDate);
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("Plan_ID"),
	            		 							resultSet.getLong("Request_ID"),
	            		 							resultSet.getLong("Dispatcher_ID"),
	            		 							resultSet.getLong("Team_ID"),
	            		 							resultSet.getTimestamp("Estimated_execute_date"),
	            		 							resultSet.getTimestamp("Estimated_start_date"),
	            		 							resultSet.getString("Comment"));
	           
	             resultList.add(plan);
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
	public List<WorkingPlan> getPlansByStartDate(Timestamp startDate) {
		
		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Working_plan WHERE "
				+ "(unix_timestamp(Estimated_start_date)-unix_timestamp(?))<86400"
				+ " AND (unix_timestamp(Estimated_start_date)-unix_timestamp(?))>0";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setTimestamp(1, startDate);
			 statement.setTimestamp(2, startDate);
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("Plan_ID"),
	            		 							resultSet.getLong("Request_ID"),
	            		 							resultSet.getLong("Dispatcher_ID"),
	            		 							resultSet.getLong("Team_ID"),
	            		 							resultSet.getTimestamp("Estimated_execute_date"),
	            		 							resultSet.getTimestamp("Estimated_start_date"),
	            		 							resultSet.getString("Comment"));
	           
	             resultList.add(plan);
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
	public WorkingPlan getPlanByRequest(Request request) {
		
		WorkingPlan plan = new WorkingPlan();
		String sql = "SELECT * FROM Working_plan WHERE Request_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, request.getId());
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
	         plan.setId(resultSet.getLong("Plan_ID"));
	         plan.setRequestId(resultSet.getLong("Request_ID"));
	         plan.setDispatcherId(resultSet.getLong("Dispatcher_ID"));
	         plan.setWorkTeamId(resultSet.getLong("Team_ID"));
	         plan.setEstimatedExecutionDate(resultSet.getTimestamp("Estimated_execute_date"));
	         plan.setEstimatedStartDate(resultSet.getTimestamp("Estimated_start_date"));
	         plan.setComment(resultSet.getString("Comment"));
	         
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return plan;
	}

	@Override
	public List<WorkingPlan> getDoneWorkingPlans() {

		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT p.Plan_ID, p.Request_ID, p.Dispatcher_ID, p.Team_ID, p.Estimated_execute_date,"
				+ " p.Estimated_start_date, p.Comment FROM Request r INNER JOIN Working_plan p "
				+ "ON r.Request_ID = p.Request_ID WHERE CURRENT_TIMESTAMP()>p.Estimated_execute_date";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("p.Plan_ID"),
	            		 							resultSet.getLong("p.Request_ID"),
	            		 							resultSet.getLong("p.Dispatcher_ID"),
	            		 							resultSet.getLong("p.Team_ID"),
	            		 							resultSet.getTimestamp("p.Estimated_execute_date"),
	            		 							resultSet.getTimestamp("p.Estimated_start_date"),
	            		 							resultSet.getString("p.Comment"));
	           
	             resultList.add(plan);
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
	public List<WorkingPlan> getWorkingPlansInProcess() {

		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT p.Plan_ID, p.Request_ID, p.Dispatcher_ID, p.Team_ID, p.Estimated_execute_date,"
				+ " p.Estimated_start_date, p.Comment FROM Request r INNER JOIN Working_plan p "
				+ "ON r.Request_ID = p.Request_ID WHERE CURRENT_TIMESTAMP()<p.Estimated_execute_date";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("p.Plan_ID"),
	            		 							resultSet.getLong("p.Request_ID"),
	            		 							resultSet.getLong("p.Dispatcher_ID"),
	            		 							resultSet.getLong("p.Team_ID"),
	            		 							resultSet.getTimestamp("p.Estimated_execute_date"),
	            		 							resultSet.getTimestamp("p.Estimated_start_date"),
	            		 							resultSet.getString("p.Comment"));
	           
	             resultList.add(plan);
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
	public List<WorkingPlan> getPlansByKindOfWork(KindOfWork kindOfWork) {
		
		List<WorkingPlan> resultList = new ArrayList<>();
		
		String sql = "SELECT p.Plan_ID, p.Request_ID, p.Dispatcher_ID, p.Team_ID, p.Estimated_execute_date,"
				+ " p.Estimated_start_date, p.Comment FROM kind_of_work k, Request r INNER JOIN Working_plan p"
				+ " ON r.Request_ID = p.Request_ID WHERE k.Kind_ID=? AND k.Kind_ID=r.Kind_ID";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, kindOfWork.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	             WorkingPlan plan = new WorkingPlan(resultSet.getLong("p.Plan_ID"),
	            		 							resultSet.getLong("p.Request_ID"),
	            		 							resultSet.getLong("p.Dispatcher_ID"),
	            		 							resultSet.getLong("p.Team_ID"),
	            		 							resultSet.getTimestamp("p.Estimated_execute_date"),
	            		 							resultSet.getTimestamp("p.Estimated_start_date"),
	            		 							resultSet.getString("p.Comment"));
	           
	             resultList.add(plan);
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
