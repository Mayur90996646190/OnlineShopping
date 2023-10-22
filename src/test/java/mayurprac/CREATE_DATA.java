package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class CREATE_DATA {
	public static void main(String[] args) throws SQLException {
		Random ran = new Random();
		int random = ran.nextInt();
		Connection con = null;
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		Statement state = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.nextLine();
		
		String query = "select * from TYSSS;";
		ResultSet result = state.executeQuery(query);
		
		int count = 0;
		while (result.next()) {
			if (result.getString(2).equalsIgnoreCase(name)) {
				count++;
				System.out.println(result.getString(2));
			} 
		}
		//System.out.println(count);
		if(count==0)
		{
			String query1 = "insert into TYSSS values(100"+random+",'"+name+"');";
			int update = state.executeUpdate(query1);
			System.out.println(name+" name has been inserted in mysql database");
		}
		else
		{
			System.out.println(name+" name has not been inserted in mysql database");
		}
		
		
	}
}
