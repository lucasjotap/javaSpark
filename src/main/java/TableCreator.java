import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreator {
	public static void createTable(String jdbcUrl, String userName, String password) {
		try (Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			Statement statement = connection.createStatement()) {

			String createTableQuery = "CREATE TABLE java_table ("
				+ "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "first_name VARCHAR(50),"
				+ "last_name VARCHAR(50),"
				+ "email VARCHAR(100),"
				+ "gender VARCHAR(10),"
				+ "ip_address VARCHAR(15),"
				+ "age INT,"
				+ "location VARCHAR(100)"
				+ ")";
			statement.executeUpdate(createTableQuery);

			System.out.println("Table built boyyyyy!");
		}catch (Exception e) {
			System.err.println("Error creating table: " + e.getMessage());
		}
	}
}