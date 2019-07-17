package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMySQL {
	public Connection conn;
	
	public ConnectMySQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://10.132.48.225:3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
					, "root", "zxc123__");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
