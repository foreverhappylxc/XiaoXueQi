package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import myJavaBean.ModifyTable;

/**
 * Servlet implementation class UpdateSection
 */
@WebServlet("/UpdateSection")
public class UpdateSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String course_id = request.getParameter("course_id");
		String course_order = request.getParameter("course_order");
		String year = request.getParameter("year");
		String season = request.getParameter("season");
		String time = request.getParameter("time");
		String mount = request.getParameter("mount");
		String room_no = request.getParameter("room_no");
		String time_no = request.getParameter("time_no");
		
		response.setCharacterEncoding("utf-8");
		ModifyTable mt = new ModifyTable();
		boolean success = mt.updateSection(course_id, course_order, year, season, time, mount, room_no, time_no);
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		try {
			jo.put("success", success);
			json.put(jo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
