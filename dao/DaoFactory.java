package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import pack2.DaoFactory;
import pack2.ProdDaoImpl;

public class DaoFactory
{
	private static BasicDataSource connPool;
	private static DAOPlayerImpl daoPlayer;
	

	public static void initConnPool(){
		connPool = new BasicDataSource();
		connPool.setDriverClassName("com.mysql.jdbc.Driver");
		connPool.setUrl("jdbc:mysql://localhost:3306/motivater");
		connPool.setUsername("root");
		connPool.setPassword("password");
		connPool.setMaxIdle(4);
		connPool.setInitialSize(4);
		connPool.setMaxTotal(10);
	}
	
	public static DAOPlayerImpl getDAOPlayer() {
		if (daoPlayer == null){
			synchronized (DaoFactory.class) {
				if (daoPlayer == null){
					daoPlayer = new DAOPlayerImpl();
				}
			}
		}
		return daoPlayer;
	}
	public static Connection getConnection() {
		Connection conn = null; 
		try
		{
		 conn = connPool.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	return conn;
	}
}
