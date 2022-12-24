package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;



public class JDBC {
	public static Connection getConnection() {

		Connection connection = null;
		try {
			DriverManager.registerDriver(new SQLServerDriver() );
			String connectionURL = "jdbc:sqlserver://DESKTOP-VKQ44VR\\\\SQLEXPRESS:1433;databaseName=QLORDER;\"+\"encrypt=true;trustServerCertificate=true;sslProtocol=TlSv1.2";
			String userName = "sa";
			String passWord = "Toiladung123";
			connection = DriverManager.getConnection(connectionURL, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				System.out.println(c.getMetaData().getDatabaseProductName());
				System.out.println(c.getMetaData().getDatabaseProductVersion());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
