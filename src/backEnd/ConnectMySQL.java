package backEnd;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMySQL {
	public Connection conn;
	
	public ConnectMySQL()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+ InetAddress.getByName("rm-2zeiq110a99qr23bdwo.mysql.rds.aliyuncs.com").getHostAddress() + ":3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
			        + "&allowPublicKeyRetrieval=true"
					, "fhlxc", "@lxc447730");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
