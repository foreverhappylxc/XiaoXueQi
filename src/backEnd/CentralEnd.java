package backEnd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Customer;
import entity.Task;

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
	
	public boolean modifyUserInfo(String cu_id,String cu_pwd,String cu_nickname, int cu_age, String cu_email, String cu_campus, int cu_qq) {
		ConnectMySQL connectMySQL = new ConnectMySQL();
		String sql = "update customer set cu_nickname=?,cu_age=?,cu_email=?,cu_campus=?,cu_qq=?,cu_pwd=? where cu_id=?";
		try {
			PreparedStatement preparedStatement = connectMySQL.conn.prepareStatement(sql);
			preparedStatement.setString(1, cu_nickname);
			preparedStatement.setInt(2, cu_age);
			preparedStatement.setString(3, cu_email);
			preparedStatement.setString(4, cu_campus);
			preparedStatement.setInt(5, cu_qq);
			preparedStatement.setString(6, cu_pwd);
			preparedStatement.setString(7, cu_id);
			preparedStatement.execute();
			preparedStatement.close();
			connectMySQL.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Task> findAllTask()
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task;";
		try {
			Statement statement = connectMySQL.conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				Task task = new Task();
				task.setT_id(resultSet.getInt("t_id"));
				task.setCu_id(resultSet.getString("cu_id"));
				task.setT_title(resultSet.getString("t_title"));
				task.setT_content(resultSet.getString("t_content"));
				task.setT_amount(resultSet.getInt("t_amount"));
				task.setT_state(resultSet.getString("t_state"));
				task.setT_num(resultSet.getInt("t_num"));
				task.setT_class(resultSet.getString("t_class"));
				task.setP_btime(resultSet.getTimestamp("p_btime"));
				task.setP_etime(resultSet.getTimestamp("p_etime"));
				task.setT_money(resultSet.getInt("t_money"));
				task.setT_campus(resultSet.getString("t_campus"));
				task.setT_rank(resultSet.getString("t_rank"));
				arrayList.add(task);
			}
			resultSet.close();
			connectMySQL.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ArrayList<Task> findPart1Task(String where, String cu_id)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task where t_state=? and cu_id=?;";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, where);
			statement.setString(2, cu_id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Task task = new Task();
				task.setT_id(resultSet.getInt("t_id"));
				task.setCu_id(resultSet.getString("cu_id"));
				task.setT_title(resultSet.getString("t_title"));
				task.setT_content(resultSet.getString("t_content"));
				task.setT_amount(resultSet.getInt("t_amount"));
				task.setT_state(resultSet.getString("t_state"));
				task.setT_num(resultSet.getInt("t_num"));
				task.setT_class(resultSet.getString("t_class"));
				task.setP_btime(resultSet.getTimestamp("p_btime"));
				task.setP_etime(resultSet.getTimestamp("p_etime"));
				task.setT_money(resultSet.getInt("t_money"));
				task.setT_campus(resultSet.getString("t_campus"));
				task.setT_rank(resultSet.getString("t_rank"));
				arrayList.add(task);
			}
			resultSet.close();
			connectMySQL.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ArrayList<Task> findPart2Task(String where, String cu_id)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task natural join recieve where t_state=? and cu_id=?;";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, where);
			statement.setString(2, cu_id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Task task = new Task();
				task.setT_id(resultSet.getInt("t_id"));
				task.setCu_id(resultSet.getString("cu_id1"));
				task.setT_title(resultSet.getString("t_title"));
				task.setT_content(resultSet.getString("t_content"));
				task.setT_amount(resultSet.getInt("t_amount"));
				task.setT_state(resultSet.getString("t_state"));
				task.setT_num(resultSet.getInt("t_num"));
				task.setT_class(resultSet.getString("t_class"));
				task.setP_btime(resultSet.getTimestamp("p_btime"));
				task.setP_etime(resultSet.getTimestamp("p_etime"));
				task.setT_money(resultSet.getInt("t_money"));
				task.setT_campus(resultSet.getString("t_campus"));
				task.setT_rank(resultSet.getString("t_rank"));
				arrayList.add(task);
			}
			resultSet.close();
			connectMySQL.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
}
