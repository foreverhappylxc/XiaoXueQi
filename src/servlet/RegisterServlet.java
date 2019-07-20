package servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
		
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String cu_id = request.getParameter("Username");

		String cu_pwd = request.getParameter("password");

		String  cu_email=request.getParameter("Your Email");
		
		//DB
		
		try {
			
			//DB
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}