package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnectivity {
	public static Connection con;
	static {
		String url = "jdbc:mysql://localhost:3306/shop";
		String username = "root";
		String pass = "";

		try {
			con = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
