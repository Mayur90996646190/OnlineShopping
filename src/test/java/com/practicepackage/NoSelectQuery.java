package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQuery {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
			Statement state = con.createStatement();
			String query = "insert into project values('API','Sachin','Bangalore',1)";
			int result = state.executeUpdate(query);
			if (result >= 1) {
				System.out.println("Data is created");
			} else
				System.out.println("Data is not Created");
		} catch (Exception e) {

		}
		finally {
			con.close();
		}

	}
}
