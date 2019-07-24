package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backEnd.TaskDAOImpl;
import entity.Task;

import java.io.IOException;
import java.util.ArrayList;
public class SearchTasksByDifficulty  extends HttpServlet {
		
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("SearchTasksByDifficulty");
			request.setCharacterEncoding("utf-8");
			String rank= request.getParameter("Rank");//从网页接受Rank的Post
			System.out.println(rank);
			
			TaskDAOImpl dao = new TaskDAOImpl();
			ArrayList<Task> list = dao.searchTasksByDifficulty(rank);
			HttpSession session = request.getSession();
			session.setAttribute("TaskList", list); //¸更新session
			response.sendRedirect("about1.jsp");
		}

	}
