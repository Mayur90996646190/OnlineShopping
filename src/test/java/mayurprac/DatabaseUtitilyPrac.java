package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.osa.genericUtils.IpathConstants;

public class DatabaseUtitilyPrac {
	Connection con = null;
	public void getConnectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con =DriverManager.getConnection(IpathConstants.excelpath,IpathConstants.dbURL,IpathConstants.dbPassword);
	}
	
	public String executeQueryandGetData(String query, int columnNo, String expDta) throws Throwable {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{	String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(expDta)) {
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data is verified");
			return expDta;
		}
		else
		{
			System.out.println("Data is not verified");
			return expDta;
		}
	}
			
}
