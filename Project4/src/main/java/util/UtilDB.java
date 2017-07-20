package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class UtilDB {
	
	private static final Logger logger = Logger.getLogger(UtilDB.class);
	private static DataSource dataSource = null;
	
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/utilDB");
		} catch (NamingException e){
			logger.error(e);
		}
	}
	
    private UtilDB(){
    	
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}