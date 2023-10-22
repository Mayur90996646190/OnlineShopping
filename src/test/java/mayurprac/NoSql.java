package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSql {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51","root","root");
		Statement state = con.createStatement();
		String query = "insert into project values ('API','manikanta','Bangalore',1)";
		
		}
}
