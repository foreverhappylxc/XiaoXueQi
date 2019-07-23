package backEnd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Customer;

public class CentralEnd {
	public Customer customerInfo(String cu_id)
	{
		String sql = "select * from customer where cu_id = ?";
		Customer customer = new Customer();
		ConnectMySQL connectMySQL = new ConnectMySQL();
		try {
			PreparedStatement preparedStatement = connectMySQL.conn.prepareStatement(sql);
			preparedStatement.setString(1, cu_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				customer.setCu_id(resultSet.getString("cu_id"));
				customer.setCu_pwd(resultSet.getString("cu_pwd"));
				customer.setCu_name(resultSet.getString("cu_name"));
				customer.setCu_nickname(resultSet.getString("cu_nickname"));
				customer.setCu_age(resultSet.getInt("cu_age"));
				customer.setCu_sex(resultSet.getString("cu_age"));
				customer.setCu_email(resultSet.getString("cu_email"));
				customer.setCu_credit(resultSet.getInt("cu_credit"));
				customer.setCu_campus(resultSet.getString("cu_campus"));
				customer.setCu_authority(resultSet.getString("cu_authority"));
				customer.setCu_img(resultSet.getString("cu_img"));
				customer.setCu_qq(resultSet.getInt("cu_qq"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
