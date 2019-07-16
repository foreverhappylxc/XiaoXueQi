package myJavaBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import myJavaBean.ConnectSQL;

public class CheckPassword {
	public ConnectSQL cSQL = new ConnectSQL();
	
	public boolean checkIDPassword(String ID, String pwd, String type)
	{
		try {
			String sql = "select password from " + type + " where id=?";
			PreparedStatement ps = cSQL.conn.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int l = rs.getRow();
			rs.first();
			if (l == 1)
			{
				if (rs.getString("password").equals(pwd))
				{
					ps.close();
					cSQL.conn.close();
					return true;
				}
				else {
					ps.close();
					cSQL.conn.close();
					return false;
				}
			}
			else {
				ps.close();
				cSQL.conn.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
