package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryTest {
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51","root","root");
		Statement state=con.createStatement();
		String query = "insert into project values ('java','Rajesh','Bangalore',1)";
		int	result=state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is written to the sdet51");
		}
		else
			System.out.println("data is not written to the sdet51");
	}
}
