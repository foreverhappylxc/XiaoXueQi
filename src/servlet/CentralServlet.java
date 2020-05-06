package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import backEnd.CentralEnd;
import entity.Customer;
import entity.Task;

/**
 * Servlet implementation class CentralServler
 */
@WebServlet("/CentralServlet")
public class CentralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentralServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cu_id;
		Customer customer = new Customer();
		int val = Integer.parseInt(request.getParameter("val"));
		HttpSession session = request.getSession();
		CentralEnd centralEnd = new CentralEnd();
		
		cu_id = (String)session.getAttribute("cu_id");
		session.setAttribute("val", val);
		
		if (val == 1)
		{
			customer = centralEnd.customerInfo(cu_id);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("centralInfo.jsp").forward(request, response);
		}
		
		if (val == 2)
		{
			cu_id = request.getParameter("cu_id");
			String cu_nickname = request.getParameter("cu_nickname");
			String cu_pwd = request.getParameter("cu_pwd");
			int cu_age = Integer.parseInt(request.getParameter("cu_age"));
			String cu_email = request.getParameter("cu_email");
			String cu_campus = request.getParameter("cu_campus");
			int cu_qq = Integer.parseInt(request.getParameter("cu_qq"));
			
			boolean success = centralEnd.modifyUserInfo(cu_id, cu_pwd, cu_nickname, cu_age, cu_email, cu_campus, cu_qq);
			JSONObject jo = new JSONObject();
			JSONArray json = new JSONArray();
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
		
		if(val == 3)
		{
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = centralEnd.findAllTask();
			for (Task task: arrayList)
			{
				JSONObject jo = new JSONObject();
				try {
					jo.put("t_id", task.getT_id());
					jo.put("cu_id", task.getCu_id());
					jo.put("t_title", task.getT_title());
					jo.put("t_content", task.getT_content());
					jo.put("t_amount", task.getT_amount());
					jo.put("t_state", task.getT_state());
					jo.put("t_num", task.getT_num());
					jo.put("t_class", task.getT_class());
					jo.put("p_btime", task.getP_btime());
					jo.put("p_etime", task.getP_etime());
					jo.put("t_money", task.getT_money());
					jo.put("t_campus", task.getT_campus());
					jo.put("t_rank", task.getT_rank());
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
		
		if(val == 4)
		{
			String where = request.getParameter("where");
			session.setAttribute("where", where);
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = centralEnd.findPart1Task(where, cu_id);
			for (Task task: arrayList)
			{
				JSONObject jo = new JSONObject();
				try {
					jo.put("t_id", task.getT_id());
					jo.put("cu_id", task.getCu_id());
					jo.put("t_title", task.getT_title());
					jo.put("t_content", task.getT_content());
					jo.put("t_amount", task.getT_amount());
					jo.put("t_state", task.getT_state());
					jo.put("t_num", task.getT_num());
					jo.put("t_class", task.getT_class());
					jo.put("p_btime", task.getP_btime());
					jo.put("p_etime", task.getP_etime());
					jo.put("t_money", task.getT_money());
					jo.put("t_campus", task.getT_campus());
					jo.put("t_rank", task.getT_rank());
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
		
		if(val == 5)
		{
			String where = request.getParameter("where");
			session.setAttribute("where", where);
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = centralEnd.findPart2Task(where, cu_id);
			for (Task task: arrayList)
			{
				JSONObject jo = new JSONObject();
				try {
					jo.put("t_id", task.getT_id());
					jo.put("cu_id", task.getCu_id());
					jo.put("t_title", task.getT_title());
					jo.put("t_content", task.getT_content());
					jo.put("t_amount", task.getT_amount());
					jo.put("t_state", task.getT_state());
					jo.put("t_num", task.getT_num());
					jo.put("t_class", task.getT_class());
					jo.put("p_btime", task.getP_btime());
					jo.put("p_etime", task.getP_etime());
					jo.put("t_money", task.getT_money());
					jo.put("t_campus", task.getT_campus());
					jo.put("t_rank", task.getT_rank());
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
