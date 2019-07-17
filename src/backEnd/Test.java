package backEnd;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectMySQL connectMySQL = new ConnectMySQL();
		if (connectMySQL.conn != null)
		{
			System.out.print("数据库连接成功");
			try {
				connectMySQL.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.print("数据库连接失败");
		}
	}

}
