package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import myJavaBean.Find;

/**
 * Servlet implementation class FindDepartment
 */
@WebServlet("/FindDepartment")
public class FindDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDepartment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val = request.getParameter("val");
		String success = request.getParameter("success");
		
		Find find = new Find();
		List<String> list = find.dept_name();
		request.setAttribute("list", list);
		
		if (!val.equals("5"))
		{
			request.setAttribute("success", success);
		}
	
		if (val.equals("1")) request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		if (val.equals("2")) request.getRequestDispatcher("addMajor.jsp").forward(request, response);
		if (val.equals("3")) request.getRequestDispatcher("addTeacher.jsp").forward(request, response);
		if (val.equals("4")) 
			{
			List<String> list1 = find.course_id();
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("addCourse.jsp").forward(request, response);
			}
		if (val.equals("5")) 
		{
			request.setAttribute("success1", success);
			List<String> list1 = find.course_id();
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("addCourse.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Find find = new Find();
		List<String> list = find.dept_name();
		JSONArray json = new JSONArray();
		for (String s: list)
		{
			JSONObject jo = new JSONObject();
			try {
				jo.put("dept_name", s);
				json.put(jo);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}

}
