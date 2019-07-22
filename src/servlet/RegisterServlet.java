package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backEnd.ConnectMySQL;
import backEnd.DAO;
import entity.Customer;

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

		String cu_id = request.getParameter("UserID");
		String cu_name = request.getParameter("Username");
		String cu_nickname = request.getParameter("UsernameNick");
		String cu_sex = request.getParameter("Sex");
		String age = request.getParameter("Age");
		String cu_campus = request.getParameter("Campus");
		String cu_email=request.getParameter("Email");
		String qq = request.getParameter("QQ");
		String cu_pwd = request.getParameter("Password");
		String confirmpwd = request.getParameter("ConfirmPassword");//?wait to update
		
		int cu_age =Integer.parseInt(age);
		int  cu_qq = Integer.parseInt(qq);
		int cu_credit=0;
		String cu_authority="一般权限";
		
		ConnectMySQL customerregister = new ConnectMySQL();
		Customer customer = new Customer(cu_id,cu_pwd,cu_name,cu_nickname,cu_age,cu_sex,cu_email,cu_campus,cu_qq,cu_credit,cu_authority);
		DAO dao=new DAO();
		try {
			Connection connection=customerregister.conn;
			if(dao.register(connection, customer)) {
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("register.jsp");
			}//是否已经注册
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}