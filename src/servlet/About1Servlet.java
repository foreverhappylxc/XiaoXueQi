package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import backEnd.About1Find;
import entity.Task;

/**
 * Servlet implementation class About1Servlet
 */
@WebServlet("/About1Servlet")
public class About1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public About1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String value = request.getParameter("value");
		String con = request.getParameter("con");
		String str = request.getParameter("str");
		About1Find about1Find = new About1Find();
		
		if(value.equals("1"))
		{
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = about1Find.find1Task(con, str);
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
		if(value.equals("2"))
		{
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = about1Find.find2Task(con, str);
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
		if(value.equals("3"))
		{
			JSONArray json = new JSONArray();
			ArrayList<Task> arrayList = about1Find.find3Task(con, str);
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
}
