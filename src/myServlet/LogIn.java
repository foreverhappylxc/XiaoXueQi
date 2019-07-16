package myServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJavaBean.CheckPassword;;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckPassword cpw = new CheckPassword();
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String type = request.getParameter("type");
		String js = request.getParameter("js");
		if (type.equals("manager"))
		{
			if (cpw.checkIDPassword(ID, pwd, type))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("id", ID);
				request.getRequestDispatcher("managerHome.jsp").forward(request, response);
			}
			else {
				if (js.equals("true")) request.setAttribute("errorMsg", "用户名或密码错误");
				else {
					request.setAttribute("errorMsg", "");
				}
				request.getRequestDispatcher("managerLogIn.jsp").forward(request, response);
			}
		}
		if (type.equals("student"))
		{
			if (cpw.checkIDPassword(ID, pwd, type))
			{
				HttpSession session1 = request.getSession(true);
				session1.setAttribute("id1", ID);
				request.getRequestDispatcher("studentHome.jsp").forward(request, response);
			}
			else {
				if (js.equals("true")) request.setAttribute("errorMsg", "用户名或密码错误");
				else {
					request.setAttribute("errorMsg", "");
				}
				request.getRequestDispatcher("studentLogIn.jsp").forward(request, response);
			}
		}
		if (type.equals("teacher"))
		{
			if (cpw.checkIDPassword(ID, pwd, type))
			{
				HttpSession session2 = request.getSession(true);
				session2.setAttribute("id2", ID);
				request.getRequestDispatcher("teacherHome.jsp").forward(request, response);
			}
			else {
				if (js.equals("true")) request.setAttribute("errorMsg", "用户名或密码错误");
				else {
					request.setAttribute("errorMsg", "");
				}
				request.getRequestDispatcher("teacherLogIn.jsp").forward(request, response);
			}
		}
	}

}
