package myServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myJavaBean.Find;

/**
 * Servlet implementation class Department
 */
@WebServlet("/Department")
public class Department extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currPage = 1;
		int pages;
		Find find = new Find();
		StringBuffer sb = new StringBuffer();
		int count = find.findCount("department");
		if (request.getParameter("page") != null)
		{
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		List<myJavaBean.Department> list = find.department(currPage);
		request.setAttribute("list", list);
		if (count % myJavaBean.Department.PAGE == 0)
		{
			pages = count / myJavaBean.Department.PAGE;
		}
		else 
		{
			pages = count / myJavaBean.Department.PAGE + 1;
		}
		for (int i = 1; i <= pages; i++)
		{
			if (i == currPage)
			{
				sb.append("【" + i + "】");
			}
			else 
			{
				sb.append("<a href='Department?page=" + i +"'>" + i + "</a>");
			}
			sb.append(" ");
		}
		request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("findDepartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
