package backEnd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Task;

public class TaskDAOImpl implements TaskDAO{

	private ConnectMySQL conn;
	public TaskDAOImpl() {
		this.conn=new ConnectMySQL();
	}
	@Override
	public boolean addTask(int t_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTask(int t_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Task> showTask() {
		
        return null;
	}

	@Override
	public ArrayList<Task> searchTasksByDifficulty(String rank) {
		String sql="select * from task where t_rank=";
        ArrayList<Task> list = new ArrayList<>();
        ResultSet rs = conn.query(sql);
        try {
            while(rs.next()){
            	Task task = new Task(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getString(8), rs.getDate(9), rs.getDate(10),rs.getInt(11), rs.getString(12), rs.getString(13));
                list.add(task);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}


}
