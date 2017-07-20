package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IWorkTeamDao;
import entity.WorkTeam;
import util.UtilDB;

public class WorkTeamDBDao implements IWorkTeamDao {

	private static final Logger logger = Logger.getLogger(WorkingPlanDBDao.class);
	private static final WorkTeamDBDao WORK_TEAM_DB_DAO = new WorkTeamDBDao();
	
	private WorkTeamDBDao() {
		
	}
	
	public static WorkTeamDBDao getInstance() {
		return WORK_TEAM_DB_DAO;
	}
	
	@Override
	public void add(WorkTeam team) {
		
		String sql = "INSERT INTO Work_Team (Team_ID, Lead_ID, Name_of_team) VALUES(?, ?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, team.getId());
            statement.setLong(2, team.getLeadId());
            statement.setString(3, team.getName());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<WorkTeam> getAll() {
		
		List<WorkTeam> resultList = new ArrayList<>();
		
		String sql = "SELECT Team_ID, Lead_ID, Name_of_team FROM Work_team";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             WorkTeam workTeam = new WorkTeam(resultSet.getLong("Team_ID"),
	            		 						  resultSet.getLong("Lead_ID"),
	            		 						  resultSet.getString("Name_of_team"));
	           
	             resultList.add(workTeam);
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
	public WorkTeam getById(Long id) {
		
		WorkTeam workTeam = new WorkTeam();
		String sql = "SELECT Team_ID, Lead_ID, Name_of_team FROM Work_team WHERE Team_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 workTeam.setId(resultSet.getLong("Team_ID"));
			 workTeam.setLeadId(resultSet.getLong("Lead_ID"));
			 workTeam.setName(resultSet.getString("Name_of_team"));
			 
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return workTeam;
	}

	@Override
	public void update(WorkTeam team) {
	
		String sql = "UPDATE Work_team SET Lead_ID=?, Name_of_team=? WHERE Team_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, team.getLeadId());
            statement.setString(2, team.getName());
            statement.setLong(3, team.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(WorkTeam team) {
		
		String sql = "DELETE FROM Work_team WHERE Team_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, team.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}
}
