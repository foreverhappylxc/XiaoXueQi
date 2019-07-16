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
 * Servlet implementation class AddSection
 */
@WebServlet("/AddSection")
public class AddSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Find find = new Find();
		JSONArray json = find.courseArray();
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
		String course_id = request.getParameter("ci");
		String course_order = request.getParameter("course_order");
		String year = request.getParameter("year");
		String season = request.getParameter("season");
		String time = request.getParameter("time");
		String mount = request.getParameter("mount");
		
		ModifyTable mt = new ModifyTable();
		
		boolean success = mt.addSection(course_id, course_order, year, season, time, mount);
		
		response.sendRedirect("FindDepartment?val=5&success=" + success);
	}

}
