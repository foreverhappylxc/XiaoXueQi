package backEnd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import entity.Task;

public class About1Find {
	public ArrayList<Task> find1Task(String con, String str)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task where t_state='进行中' and t_class=? and t_content like '%" + str +"%';";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, con);
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
	public ArrayList<Task> find2Task(String con, String str)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task where t_state='进行中' and t_campus=? and t_content like '%" + str +"%';";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, con);
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
	public ArrayList<Task> find3Task(String con, String str)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task where t_state='进行中' and t_rank=? and t_content like '%" + str +"%';";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, con);
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
	public ArrayList<Task> find4Task(String t_class, String t_campus,String str)
	{
		ConnectMySQL connectMySQL = new ConnectMySQL();
		ArrayList<Task> arrayList = new ArrayList<Task>();
		String sql = "select * from task where t_state='进行中' and t_class=? and t_campus=? and t_content like '%" + str +"%';";
		try {
			PreparedStatement statement = connectMySQL.conn.prepareStatement(sql);
			statement.setString(1, t_class);
			statement.setString(2, t_campus);
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
}
