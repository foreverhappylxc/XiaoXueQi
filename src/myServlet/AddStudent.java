package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import myJavaBean.Find;
import myJavaBean.ModifyTable;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Find find = new Find();
		JSONArray json = find.majorArray();
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String id_card = request.getParameter("id_card");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String class_id = request.getParameter("class_id");
		String enrollment_time = request.getParameter("enrollment_time");
		String dept_name = request.getParameter("dept_name");
		String major = request.getParameter("major");
		String birthday = request.getParameter("birthday");
		
		ModifyTable mt = new ModifyTable();
		
		boolean success = mt.addStudent(id, id_card, password, name, sex, address, telephone
				, class_id, enrollment_time, dept_name, major, birthday);
		
		response.sendRedirect("FindDepartment?val=1&success=" + success);
	}

}
