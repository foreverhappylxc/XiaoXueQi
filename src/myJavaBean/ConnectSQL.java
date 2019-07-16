package myJavaBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {
	public Connection conn;
	
	public ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usi?useSSL=false&serverTimezone=GMT"
					, "root", "zxc123__");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
