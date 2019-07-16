package myJavaBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Find {
	public String email(String id, String table)
	{
		String s = null;
		String sql = "select e_mail from " + table + " where id=?";
		ConnectSQL cs = new ConnectSQL();
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString(1);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}
	
	public List<String> dept_name() {
		List<String> list = new ArrayList<String>();
		String sql = "select dept_name from department";
		ConnectSQL cs = new ConnectSQL();
		
		try {
			Statement st = cs.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String s = rs.getString(1);
				list.add(s);
			}
			rs.close();
			st.close();
			cs.conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public String findTeacher(String id) {
		String sql = "select dept_name from teacher where id = ?";
		String s = null;
		ConnectSQL cs = new ConnectSQL();
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString(1);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public Student info(String id) {
		String sql = "select * from student where id = ?";
		ConnectSQL cs = new ConnectSQL();
		Student student = new Student();;
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student.setId(rs.getString("id"));
				student.setId_card(rs.getString("id_card"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAddress(rs.getString("address"));
				student.setTelephone(rs.getString("telephone"));
				student.setClass_id(rs.getString("class_id"));
				student.setEnrollment_time(rs.getString("enrollment_time"));
				student.setDept_name(rs.getString("dept_name"));
				student.setMajor(rs.getString("major"));
				student.setBirthday(rs.getString("birthday"));
				student.setTotal_cred(rs.getString("total_cred"));
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public int findCount(String table) {
		int count = 0;
		ConnectSQL cs = new ConnectSQL();
		String sql = "select count(*) from " + table;
		try {
			Statement s = cs.conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) count = rs.getInt(1);
			s.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int findCount(String table, String str, String where) {
		int count = 0;
		ConnectSQL cs = new ConnectSQL();
		String sql = "select count(*) from " + table + " where " + str + "='" + where + "'";
		if (table.equals("section"))
		{
			sql = "select count(*) from course natural join section where " + str + "='" + where + "'";
		}
		if (table.equals("take"))
		{
			sql = "select count(*) from course natural join teaches where " + str + "='" + where + "'";
		}
		if (table.equals("student"))
		{
			sql = "select count(*) from student natural join take natural join (select course_id,course_name,credits from course)as yiyu where " + where;
		}
		try {
			Statement s = cs.conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) 
				count = rs.getInt(1);
			s.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Department> department(int page) {
		List<Department> list = new ArrayList<Department>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from department order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Department.PAGE);
			ps.setInt(2, Department.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setDept_name(rs.getString(1));
				department.setBuilding(rs.getString(2));
				department.setPresident(rs.getString(3));
				department.setVice_president(rs.getString(4));
				department.setDescription(rs.getString(5));
				list.add(department);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Major> major(int page, String dept_name) {
		List<Major> list = new ArrayList<Major>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from major where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from major order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Major.PAGE);
			ps.setInt(2, Major.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Major major = new Major();
				major.setId(rs.getString(1));
				major.setName(rs.getString(2));
				major.setDept_name(rs.getString(3));
				major.setManager(rs.getString(4));
				list.add(major);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Teacher> teacher(int page, String dept_name) {
		List<Teacher> list = new ArrayList<Teacher>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from teacher where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from teacher order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Teacher.PAGE);
			ps.setInt(2, Teacher.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString(1));
				teacher.setPassword(rs.getString(2));
				teacher.setName(rs.getString(3));
				teacher.setSex(rs.getString(4));
				teacher.setDept_name(rs.getString(5));
				teacher.setMajor(rs.getString(6));
				teacher.setE_mail(rs.getString(7));
				teacher.setTelephone(rs.getString(8));
				list.add(teacher);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Student> student(int page, String dept_name) {
		List<Student> list = new ArrayList<Student>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from student where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from student order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Student.PAGE);
			ps.setInt(2, Student.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setId_card(rs.getString(2));
				student.setPassword(rs.getString(3));
				student.setName(rs.getString(4));
				student.setSex(rs.getString(5));
				student.setAddress(rs.getString(6));
				student.setTelephone(rs.getString(7));
				student.setClass_id(rs.getString(8));
				student.setEnrollment_time(rs.getString(9));
				student.setDept_name(rs.getString(10));
				student.setMajor(rs.getString(11));
				student.setBirthday(rs.getString(12));
				student.setTotal_cred(rs.getString(13));
				list.add(student);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Course> course(int page, String dept_name) {
		List<Course> list = new ArrayList<Course>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from course where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from course order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Course.PAGE);
			ps.setInt(2, Course.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getString(1));
				course.setCourse_name(rs.getString(2));
				course.setDept_name(rs.getString(3));
				course.setCredits(rs.getString(4));
				list.add(course);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Section> section(int page, String dept_name) {
		List<Section> list = new ArrayList<Section>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from course natural join section where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from course natural join section order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Section.PAGE);
			ps.setInt(2, Section.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setCourse_id(rs.getString(1));
				section.setCourse_name(rs.getString(2));
				section.setDept_name(rs.getString(3));
				section.setCredits(rs.getString(4));
				section.setCourse_order(rs.getString(5));
				section.setYear(rs.getString(6));
				section.setSeason(rs.getString(7));
				section.setTime(rs.getString(8));
				section.setMount(rs.getString(9));
				//section.setDept_name(rs.getString(10));
				section.setRoom_no(rs.getString(11));
				section.setTime_no(rs.getString(12));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Take> take(int page, String dept_name) {
		List<Take> list = new ArrayList<Take>();
		ConnectSQL cs = new ConnectSQL();
		String sql;
		if (!dept_name.equals("所有")) sql = "select * from course natural join section natural join "
				+ "(select course_id,course_order,year,season,name from teaches natural join teacher) as yiyu"
				+ " where dept_name = '" + dept_name + "' " + "limit ?,?";
		else sql = "select * from course natural join section natural join "
				+  "(select course_id,course_order,year,season,name from teaches natural join teacher) as yiyu "
				+"order by dept_name limit ?,?";
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setInt(1, (page-1) * Take.PAGE);
			ps.setInt(2, Take.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Take section = new Take();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setDept_name(rs.getString("dept_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setYear(rs.getString("year"));
				section.setSeason(rs.getString("season"));
				section.setTime(rs.getString("time"));
				section.setMount(rs.getString("mount"));
				section.setNumous(rs.getString("numous"));
				section.setRoom_no(rs.getString("room_no"));
				section.setTime_no(rs.getString("time_no"));
				section.setName(rs.getString("name"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Take> take(String id, String year, String season) {
		List<Take> list = new ArrayList<Take>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from course natural join section natural join "
				+ "(take natural join (select course_id,course_order,year,season,name from teaches natural join teacher) as yiyu)"
				+ " where id=? and year=? and season=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Take section = new Take();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setDept_name(rs.getString("dept_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setYear(rs.getString("year"));
				section.setSeason(rs.getString("season"));
				section.setTime(rs.getString("time"));
				section.setMount(rs.getString("mount"));
				section.setNumous(rs.getString("numous"));
				section.setRoom_no(rs.getString("room_no"));
				section.setTime_no(rs.getString("time_no"));
				section.setName(rs.getString("name"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Takes> takes(String id, String year, String season) {
		List<Takes> list = new ArrayList<Takes>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from take NATURAL join course natural join (section natural join (select name,course_order, "
				+ "course_id,year,season from teaches NATURAL join teacher) as yiyu)"
				+ " where id=? and year=? and season=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Takes section = new Takes();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setRoom_no(rs.getString("room_no"));
				section.setTime_no(rs.getString("time_no"));
				section.setName(rs.getString("name"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Takes> teaches(String id, String year, String season) {
		List<Takes> list = new ArrayList<Takes>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from teaches natural join course natural join section"
				+ " where id=? and year=? and season=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Takes section = new Takes();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setRoom_no(rs.getString("room_no"));
				section.setTime_no(rs.getString("time_no"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Grade> grade(int page, String course_id,String course_order, String year, String season) {
		List<Grade> list = new ArrayList<Grade>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from student natural join take natural join (select course_id,course_name,credits from course)as yiyu"
				+ " where course_id=? and course_order=? and year=? and season=? limit ?,?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, course_id);
			ps.setString(2, course_order);
			ps.setString(3, year);
			ps.setString(4, season);
			ps.setInt(5, (page-1) * Grade.PAGE);
			ps.setInt(6, Grade.PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grade section = new Grade();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setDept_name(rs.getString("dept_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setYear(rs.getString("year"));
				section.setSeason(rs.getString("season"));
				section.setName(rs.getString("name"));
				section.setID(rs.getString("id"));
				section.setGrade(rs.getString("grade"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Grade> grade(String id, String year, String season) {
		List<Grade> list = new ArrayList<Grade>();
		ConnectSQL cs = new ConnectSQL();
		String sql = "select * from student natural join take natural join (select course_id,course_name,credits from course)as yiyu"
				+ " where year=? and season=? and id=?";
		
		try {
			PreparedStatement ps = cs.conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, season);
			ps.setString(3, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grade section = new Grade();
				section.setCourse_id(rs.getString("course_id"));
				section.setCourse_name(rs.getString("course_name"));
				section.setDept_name(rs.getString("dept_name"));
				section.setCredits(rs.getString("credits"));
				section.setCourse_order(rs.getString("course_order"));
				section.setYear(rs.getString("year"));
				section.setSeason(rs.getString("season"));
				section.setGrade(rs.getString("grade"));
				list.add(section);
			}
			rs.close();
			ps.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> course_id() {
		List<String> list = new ArrayList<String>();
		String sql = "select course_id from course";
		ConnectSQL cs = new ConnectSQL();
		
		try {
			Statement st = cs.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String s = rs.getString(1);
				list.add(s);
			}
			rs.close();
			st.close();
			cs.conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public JSONArray majorArray() {
		JSONArray json = new JSONArray();
		String sql = "select dept_name, name from major";
		ConnectSQL cs = new ConnectSQL();
		try {
			Statement st = cs.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("dept_name", rs.getString(1));
					jo.put("name", rs.getString(2));
					json.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rs.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public JSONArray courseArray() {
		JSONArray json = new JSONArray();
		String sql = "select course_id,course_name,dept_name,credits from course";
		ConnectSQL cs = new ConnectSQL();
		Statement st;
		try {
			st = cs.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("course_id", rs.getString(1));
					jo.put("course_name", rs.getString(2));
					jo.put("dept_name", rs.getString(3));
					jo.put("credits", rs.getString(4));
					json.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rs.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public JSONArray teachesArray(String id) {
		JSONArray json = new JSONArray();
		String sql = "select course_id,course_name,course_order,year,season from course natural join teaches where id=?";
		ConnectSQL cs = new ConnectSQL();
		PreparedStatement st;
		try {
			st = cs.conn.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("course_id", rs.getString("course_id"));
					jo.put("course_name", rs.getString("course_name"));
					jo.put("course_order", rs.getString("course_order"));
					jo.put("year", rs.getString("year"));
					jo.put("season", rs.getString("season"));
					json.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rs.close();
			cs.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
