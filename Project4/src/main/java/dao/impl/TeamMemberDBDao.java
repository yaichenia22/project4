package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.ITeamMemberDao;
import entity.Employee;
import entity.TeamMember;
import entity.WorkTeam;
import util.UtilDB;

public class TeamMemberDBDao implements ITeamMemberDao {

	private static final Logger logger = Logger.getLogger(TeamMemberDBDao.class);
	private static final TeamMemberDBDao TEAM_MEMBER_DB_DAO = new TeamMemberDBDao();
	
	private TeamMemberDBDao() {
		
	}
	
	public static TeamMemberDBDao getInstance() {
		return TEAM_MEMBER_DB_DAO;
	}
	
	@Override
	public void add(TeamMember member) {
		
		String sql = "INSERT INTO Team_member (Employee_ID, Team_ID) VALUES(?, ?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, member.getEmployeeId());
            statement.setLong(2, member.getTeamId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<TeamMember> getAll() {
		
		List<TeamMember> resultList = new ArrayList<>();
		
		String sql = "SELECT Team_member_ID, Employee_ID, Team_ID FROM Team_member";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	        	 TeamMember member = new TeamMember(resultSet.getLong("Team_Member_ID"),
	        			 							resultSet.getLong("Employee_ID"),
	        			 							resultSet.getLong("Team_ID"));
	           
	             resultList.add(member);
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
	public TeamMember getById(Long id) {
		
		TeamMember member = new TeamMember();
		String sql = "SELECT Team_member_ID, Employee_ID, Team_ID FROM Team_member"
				+ " WHERE Team_member_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 member.setId(resultSet.getLong("Team_member_ID"));
			 member.setEmployeeId(resultSet.getLong("Employee_ID"));
			 member.setTeamId(resultSet.getLong("Team_ID")); 
			 
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return member;
	}

	@Override
	public void update(TeamMember member) {
	
		String sql = "UPDATE Team_member SET Employee_ID=?, Team_ID=? WHERE Team_member_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setLong(1, member.getEmployeeId());
            statement.setLong(2, member.getTeamId());
            statement.setLong(3, member.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(TeamMember member) {
		
		String sql = "DELETE FROM Team_member WHERE Team_member_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, member.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<TeamMember> getAllMembersOfEmployee(Employee employee) {
		
		List<TeamMember> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Team_member WHERE Employee_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, employee.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	        	 TeamMember teamMember = new TeamMember(resultSet.getLong("Team_member_ID"),
														resultSet.getLong("Team_ID"),
														resultSet.getLong("Employee_ID"));
	        	 
	             resultList.add(teamMember);
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
	public List<TeamMember> getAllMembersFromWorkTeam(WorkTeam workTeam) {
		
		List<TeamMember> resultList = new ArrayList<>();
		
		String sql = "SELECT * FROM Team_member WHERE Team_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, workTeam.getId());
			 ResultSet resultSet = statement.executeQuery();

	         while (resultSet.next()) {
	        	 TeamMember teamMember = new TeamMember(resultSet.getLong("Team_member_ID"),
	        			 								resultSet.getLong("Team_ID"),
	        			 								resultSet.getLong("Employee_ID"));
	           
	             resultList.add(teamMember);
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
	public TeamMember getByMember(Long teamId, Long employeeId) {
		
		TeamMember member = new TeamMember();
		String sql = "SELECT Team_member_ID, Employee_ID, Team_ID FROM Team_member"
				+ " WHERE Team_ID=? AND Employee_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, teamId);
			 statement.setLong(2, employeeId);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
			 member.setId(resultSet.getLong("Team_member_ID"));
			 member.setEmployeeId(resultSet.getLong("Employee_ID"));
			 member.setTeamId(resultSet.getLong("Team_ID")); 
			 
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return member;
	}
}
