package backEnd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class ConnectMySQL {
	public Connection conn;
	
	public ConnectMySQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.43.5:3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
					, "root", "zxc123__");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
