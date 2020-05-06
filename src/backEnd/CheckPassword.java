package backEnd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckPassword {
	public boolean check(String cu_id, String cu_pwd) {
		ConnectMySQL connectMySQL = new ConnectMySQL();
		String pwd = null;
		String sql = "select cu_pwd from customer where cu_id = ?;";
		try {
			PreparedStatement ps = connectMySQL.conn.prepareStatement(sql);
			ps.setString(1, cu_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				pwd = rs.getString(1);
			}
			rs.close();
			ps.close();
			connectMySQL.conn.close();
			if (pwd.equals(cu_pwd))
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public String getInfo(String cu_id) {
		ConnectMySQL connectMySQL = new ConnectMySQL();
		String s = null;
		String sql = "select cu_nickname from customer where cu_id = ?";
		try {
			PreparedStatement ps = connectMySQL.conn.prepareStatement(sql);
			ps.setString(1, cu_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				s = rs.getString(1);
			}
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
