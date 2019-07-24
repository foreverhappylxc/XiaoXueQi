package backEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Customer;

public class RegisterDAO {
	
	public boolean register(Connection conn,Customer user)throws Exception {
		boolean flag=false;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO customer(cu_id,cu_pwd,cu_name,cu_nickname,cu_age,cu_sex,cu_email,cu_campus,cu_qq,cu_credit,cu_authority,cu_img)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";//格式调整？
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getCu_id());
		pstmt.setString(2, user.getCu_pwd());
		pstmt.setString(3, user.getCu_name());
		pstmt.setString(4, user.getCu_nickname());
		pstmt.setInt(5, user.getCu_age());
		pstmt.setString(6, user.getCu_sex());
		pstmt.setString(7, user.getCu_email());
		pstmt.setString(8, user.getCu_campus());
		pstmt.setLong(9, user.getCu_qq());
		pstmt.setInt(10, user.getCu_credit());
		pstmt.setString(11, user.getCu_authority());
		pstmt.setString(12, user.getCu_img());
		if (pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}
}
