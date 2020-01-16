package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class ConnectionManager {

	private static DruidDataSource dataSource;
	
	static {
		try {
			String path=ConnectionManager.class.getClassLoader().getResource("/").getPath();
			
			InputStream reader =new FileInputStream(new File(path+File.separator+"jdbc.properties"));
			Properties prop=new Properties();
			prop.load(reader);
			
			String driver_url=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String user=prop.getProperty("user");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxActive"));
			int minIdle=Integer.parseInt(prop.getProperty("minIdle"));
			int maxWait=Integer.parseInt(prop.getProperty("maxWait"));
			
			//线程池
			dataSource = new DruidDataSource();
			dataSource.setDriverClassName(driver_url);
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			
			dataSource.setMaxActive(maxActive);
			dataSource.setMinIdle(minIdle);
			dataSource.setRemoveAbandonedTimeout(10);
			dataSource.setRemoveAbandoned(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static Connection getConnection() {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("活动链接数量"+dataSource.getActiveCount());
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void closeConnection(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {

				conn.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
