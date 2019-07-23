package backEnd;

import entity.Task;
import java.util.ArrayList;

public interface TaskDAO {
	public boolean addTask(int t_id);
    public boolean delTask(int t_id);
    public ArrayList<Task> showTask();
    public ArrayList<Task> searchTasksByDifficulty(String rank);

}
