package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.interfaces.IKindOfWorkDao;
import entity.KindOfWork;
import util.UtilDB;

public class KindOfWorkDBDao implements IKindOfWorkDao {

	private static final Logger logger = Logger.getLogger(DispatcherDBDao.class);
	private static final KindOfWorkDBDao KIND_OF_WORK_DB_DAO = new KindOfWorkDBDao();
	
	private KindOfWorkDBDao() {
		
	}
	
	public static KindOfWorkDBDao getInstance() {
		return KIND_OF_WORK_DB_DAO;
	}
	
	@Override
	public void add(KindOfWork kindOfWork) {
		
		String sql = "INSERT INTO Kind_of_work (Name_of_kind) VALUES(?)";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, kindOfWork.getName());

            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public List<KindOfWork> getAll() {
		
		List<KindOfWork> resultList = new ArrayList<>();
		
		String sql = "SELECT Kind_ID, Name_of_kind FROM Kind_of_work";
		
		try (Connection connection = UtilDB.getConnection();
			 Statement statement = connection.createStatement()) {
			
			 ResultSet resultSet = statement.executeQuery(sql);

	         while (resultSet.next()) {
	             KindOfWork kind = new KindOfWork();
	             kind.setId(resultSet.getLong("Kind_ID"));
	             kind.setName(resultSet.getString("Name_of_kind"));
	             
	             resultList.add(kind);
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
	public KindOfWork getById(Long id) {

        KindOfWork kind = new KindOfWork();
		String sql = "SELECT Kind_ID, Name_of_kind FROM Kind_of_work WHERE Kind_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setLong(1, id);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
             kind.setId(resultSet.getLong("Kind_ID"));
             kind.setName(resultSet.getString("Name_of_kind"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return kind;
	}

	@Override
	public void update(KindOfWork kind) {
	
		String sql = "UPDATE Kind_of_work SET Name_of_kind=? WHERE Kind_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
            statement.setString(1, kind.getName());
            statement.setLong(2, kind.getId());
            
            statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}

	@Override
	public void remove(KindOfWork kind) {
		
		String sql = "DELETE FROM Kind_of_work WHERE Kind_ID=?";
		
		try (Connection connection = UtilDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
				
	        statement.setLong(1, kind.getId());
	        
	        statement.executeUpdate();
		} catch (SQLException e){
			logger.error(e);
		}
	}
	
	@Override
	public KindOfWork getByName(String name) {

        KindOfWork kind = new KindOfWork();
		String sql = "SELECT Kind_ID, Name_of_kind FROM Kind_of_work WHERE Name_of_kind=?";
		
		try (Connection connection = UtilDB.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			
			 statement.setString(1, name);
			 ResultSet resultSet = statement.executeQuery();
			 
			 resultSet.next();
             kind.setId(resultSet.getLong("Kind_ID"));
             kind.setName(resultSet.getString("Name_of_kind"));
	             
	         try {
	        	 resultSet.close();
	         } catch(SQLException e){
	        	 logger.error(e);
	         }
		} catch (SQLException e){
			logger.error(e);
		}
		
		return kind;
	}
}
