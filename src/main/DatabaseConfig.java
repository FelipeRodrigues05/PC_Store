package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConfig {
	
	public static Connection conn = null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBNAME = "PCStore";
	private  static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	private static final String LOGIN = "root";
	private static final String PASS = "";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("✅ - Connected");
			return conn;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "❌ - Missing Drivers! \n " + e.toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "❌ - Database connection problem! \n " + e.toString());
		}
		return null;
	}
	
	public void connectionClose() {
		try {
			conn.close();
			System.out.println("❌ - Desconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
