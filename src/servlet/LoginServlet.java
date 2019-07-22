package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

import backEnd.CheckPassword;

@SuppressWarnings("unused")
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
		
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String cu_id = request.getParameter("Username");
		String cu_pwd = request.getParameter("Password");
		String cu_nickname = null;
		String cu_img = null;
		boolean success = false;
		CheckPassword cp = new CheckPassword();
		JSONArray jsonArray = new JSONArray();
		JSONObject jo = new JSONObject();
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		success = cp.check(cu_id, cu_pwd);
		
		try {
			jo.put("success", success);
			jsonArray.put(jo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (success)
		{
			cu_nickname = cp.getInfo(cu_id);
			session.setAttribute("cu_id", cu_id);
			session.setAttribute("cu_nickname", cu_nickname);
			session.setAttribute("cu_img", cu_img);
		}
		
		pw.write(jsonArray.toString());
		pw.flush();
		pw.close();
	}
}

