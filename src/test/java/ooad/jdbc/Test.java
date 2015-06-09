package ooad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static void main(String[] arg) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("driver not found!!!");
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://10.141.211.151:3306/OOAD";
		try {
			@SuppressWarnings("unused")
			Connection con = DriverManager.getConnection(url, "yzf", "yzf");
		} catch (SQLException e) {
			System.out.println("failure!!!");
			e.printStackTrace();
		}
		System.out.println("success...");
		// e.printStackTrace();
	}
}
