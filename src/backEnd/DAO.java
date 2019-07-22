package backEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Customer;

public class DAO {
	
	public boolean register(Connection conn,Customer user)throws Exception {
		boolean flag=false;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO customer(cu_id,cu_pwd)VALUES(?,?)";//格式调整？
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getCu_id());
		pstmt.setString(2, user.getCu_pwd());
		if (pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}
}
