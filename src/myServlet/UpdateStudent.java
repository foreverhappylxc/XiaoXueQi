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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String total_cred = request.getParameter("total_cred");
		
		response.setCharacterEncoding("utf-8");
		ModifyTable mt = new ModifyTable();
		boolean success = mt.updateStudent(id, id_card, password, name, sex, address, telephone, class_id, enrollment_time, dept_name, major, birthday, total_cred);
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
