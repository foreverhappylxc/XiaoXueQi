package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQL {
	//÷¥––≤È—Ø
			public ResultSet query(String sql){
				System.out.println("sql: "+sql);
				try {
					Statement stmt = this.conn.createStatement();
					return stmt.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
	public Connection conn;
	
	public ConnectMySQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://10.132.49.170:3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
					, "root", "zxc123__");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
