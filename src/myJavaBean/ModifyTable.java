package myJavaBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyTable {
	
	public boolean modifyPWD(String id, String npwd, String table)
	{
		ConnectSQL cs = new ConnectSQL();
		String sql = "update " + table + " set password=? where id=?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, npwd);
			ps.setString(2, id);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addDepartment(String dept_name, String building, String president, String vice_president, String description) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into department(dept_name,building,president,vice_president,description) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, dept_name);
			ps.setString(2, building);
			ps.setString(3, president);
			ps.setString(4, vice_president);
			ps.setString(5, description);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} 
	
	public boolean addMajor(String id, String name, String dept_name, String manager) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into major(id,name,dept_name,manager) values(?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, dept_name);
			ps.setString(4, manager);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addStudent(String id, String id_card, String password, String name, String sex, String address, String telephone
			,String class_id, String enrollment_time, String dept_name, String major, String birthday) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into student(id,id_card,password,name,"
				+ "sex,address,telephone,class_id,enrollment_time,dept_name,major,birthday) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, id_card);
			ps.setString(3, password);
			ps.setString(4, name);
			ps.setString(5, sex);
			ps.setString(6, address);
			ps.setString(7, telephone);
			ps.setString(8, class_id);
			ps.setString(9, enrollment_time);
			ps.setString(10, dept_name);
			ps.setString(11, major);
			ps.setString(12, birthday);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addTeacher(String id, String password, String name, String sex, String dept_name, String major, String e_mail, String telephone) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into teacher(id,password,name,"
				+ "sex,dept_name,major,e_mail,telephone) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, sex);
			ps.setString(5, dept_name);
			ps.setString(6, major);
			ps.setString(7, e_mail);
			ps.setString(8, telephone);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addCourse(String course_id, String course_name, String dept_name, String credits) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into course(course_id,course_name,dept_name,"
				+ "credits) values(?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, course_id);
			ps.setString(2, course_name);
			ps.setString(3, dept_name);
			ps.setString(4, credits);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean addSection(String course_id, String course_order,
			String year, String season, String time, String mount) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into section(course_id,"
				+ "course_order,year,season,time,mount,numous) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, course_id);
			ps.setString(2, course_order);
			ps.setString(3, year);
			ps.setString(4, season);
			ps.setString(5, time);
			ps.setString(6, mount);
			ps.setString(7, mount);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addTeaches(String id, String course_id, String course_order,
			String year, String season) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "insert into teaches(id,course_id,"
				+ "course_order,year,season) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, course_id);
			ps.setString(3, course_order);
			ps.setString(4, year);
			ps.setString(5, season);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addTake(String id, String course_id, String course_order,
			String year, String season) {
		ConnectSQL cs = new ConnectSQL();
		String sql1 = "update section set numous = numous - 1 "
				+ "where course_id=? and course_order=? and year=? and season=?";
		int numous = 0;

		try {
			PreparedStatement ps1 = cs.conn.prepareStatement(sql1);
			ps1.setString(1, course_id);
			ps1.setString(2, course_order);
			ps1.setString(3, year);
			ps1.setString(4, season);
			ps1.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		String sql2 = "select numous from section where course_id=? and course_order=? and year=? and season=?";
		try {
			PreparedStatement ps2 = cs.conn.prepareStatement(sql2);
			ps2.setString(1, course_id);
			ps2.setString(2, course_order);
			ps2.setString(3, year);
			ps2.setString(4, season);
			ResultSet rs =ps2.executeQuery();
			while (rs.next()) {
				numous = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (numous >= 0)
		{
			String sql = "insert into take(id,course_id,"
					+ "course_order,year,season) values(?,?,?,?,?)";
			try {
				PreparedStatement ps = cs.conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, course_id);
				ps.setString(3, course_order);
				ps.setString(4, year);
				ps.setString(5, season);
				ps.execute();
				ps.close();
				cs.conn.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		sql1 = "update section set numous = numous + 1 "
				+ "where course_id=? and course_order=? and year=? and season=?"; 
		try {
			PreparedStatement ps1 = cs.conn.prepareStatement(sql1);
			ps1.setString(1, course_id);
			ps1.setString(2, course_order);
			ps1.setString(3, year);
			ps1.setString(4, season);
			ps1.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean updateDepartment(String dept_name, String building, String president, String vice_president, String description) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update department set building=?,president=?,vice_president=?,"
				+ "description=? where dept_name=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, building);
			ps.setString(2, president);
			ps.setString(3, vice_president);
			ps.setString(4, description);
			ps.setString(5, dept_name);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateMajor(String id, String name, String dept_name, String manager) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update major set name=?,dept_name=?,"
				+ "manager=? where id=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, dept_name);
			ps.setString(3, manager);
			ps.setString(4, id);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateTeacher(String id, String password, String name, String sex,
			String dept_name, String major, String e_mail, String telephone) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update teacher set password=?,name=?,sex=?,dept_name=?,"
				+ "major=?,e_mail=?,telephone=? where id=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setString(4, dept_name);
			ps.setString(5, major);
			ps.setString(6, e_mail);
			ps.setString(7, telephone);
			ps.setString(8, id);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateStudent(String id, String id_card, String password, String name, String sex,
			String address, String telephone, String class_id, String enrollment_time,
			String dept_name, String major, String birthday, String total_cred) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update student set id_card=?,password=?,name=?,sex=?,address=?,telephone=?,class_id=?,enrollment_time=?,"
				+ "dept_name=?,major=?,birthday=?,total_cred=? where id=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id_card);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, sex);
			ps.setString(5, address);
			ps.setString(6, telephone);
			ps.setString(7, class_id);
			ps.setString(8, enrollment_time);
			ps.setString(9, dept_name);
			ps.setString(10, major);
			ps.setString(11, birthday);
			ps.setString(12, total_cred);
			ps.setString(13, id);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateCourse(String course_id, String course_name, String dept_name, String credits) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update course set course_name=?,dept_name=?,credits=? where course_id=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, course_name);
			ps.setString(2, dept_name);
			ps.setString(3, credits);
			ps.setString(4, course_id);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateSection(String course_id, String course_order,
			String year, String season, String time, String mount, String room_no, String time_no) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update section set time=?,"
				+ "mount=?,numous=?,room_no=?,time_no=? where course_id=? and course_order=? and year=? and season=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, time);
			ps.setString(2, mount);
			ps.setString(3, mount);
			ps.setString(4, room_no);
			ps.setString(5, time_no);
			ps.setString(6, course_id);
			ps.setString(7, course_order);
			ps.setString(8, year);
			ps.setString(9, season);
			ps.execute();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateTake(String id, String course_id, String course_order,
			String year, String season, String grade) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "update take set grade=? "
				+ "where id=? and course_id=? and course_order=? and year=? and season=?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, grade);
			ps.setString(2, id);
			ps.setString(3, course_id);
			ps.setString(4, course_order);
			ps.setString(5, year);
			ps.setString(6, season);
			ps.execute();
			ps.close();
			cs.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteDepartment(String dept_name) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from department where dept_name = '" + dept_name + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteMajor(String id) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from major where id = '" + id + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteTeacher(String id) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from teacher where id = '" + id + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteStudent(String id) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from student where id = '" + id + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteCourse(String course_id) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from course where course_id = '" + course_id + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteSection(String course_id, String course_order, String year, String season) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from section where course_id = '" +  course_id + "'" + " and course_order = '" + course_order + "'"
				+ " and year = '"+ year + "'" + " and season = '" + season + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteTakes(String id, String course_id, String course_order, String year, String season) {
		ConnectSQL cs = new ConnectSQL();
		String sql = "delete from take where course_id = '" +  course_id + "'" + " and course_order = '" + course_order + "'"
				+ " and year = '"+ year + "'" + " and season = '" + season + "'" + "and id = '" + id + "'";
		
		Statement st;
		try {
			st = cs.conn.createStatement();
			st.execute(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		String sql1 = "update section set numous = numous + 1 "
				+ "where course_id=? and course_order=? and year=? and season=?";

		try {
			PreparedStatement ps1 = cs.conn.prepareStatement(sql1);
			ps1.setString(1, course_id);
			ps1.setString(2, course_order);
			ps1.setString(3, year);
			ps1.setString(4, season);
			ps1.execute();
			ps1.close();
			cs.conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
	}
}
