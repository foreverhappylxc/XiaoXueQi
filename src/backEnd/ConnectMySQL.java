package backEnd;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMySQL {
	public Connection conn;
	
	public ConnectMySQL()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
			        + "&allowPublicKeyRetrieval=true"
					, "fhlxc", "Zxc123..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
