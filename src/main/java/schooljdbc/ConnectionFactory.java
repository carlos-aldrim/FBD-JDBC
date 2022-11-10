package schooljdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String DB_URL = "jdbc:mysql://localhost/school";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "root";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = createConnectionToMySQL();
		
		if(conn != null) {
			System.out.println("Conecão obtida com sucesso!");
			conn.close();
		}
	}
}
