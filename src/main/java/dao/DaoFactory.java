package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DaoFactory
{
	private static BasicDataSource connPool;
	private static DAOPlayerImpl daoPlayer;

	static
	{
		connPool = new BasicDataSource();
		connPool.setDriverClassName("com.mysql.jdbc.Driver");
		connPool.setUrl("jdbc:mysql://localhost:3306/teambook");
		connPool.setUsername("root");
		connPool.setPassword("password");
		connPool.setMaxIdle(2);
		connPool.setInitialSize(2);
	}

	public static DAOPlayerImpl getDAOPlayer()
	{
		if (daoPlayer == null)
		{
			synchronized (DaoFactory.class)
			{
				if (daoPlayer == null)
				{
					daoPlayer = new DAOPlayerImpl();
				}
			}
		}
		return daoPlayer;
	}

	public static Connection getConnection()
	{
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
