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
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
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
		String dept_name = request.getParameter("dept_name");
		int count;
		if (dept_name.equals("所有"))  count = find.findCount("student");
		else {
			count = find.findCount("student", "dept_name", dept_name);
		}
		if (request.getParameter("page") != null)
		{
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		List<myJavaBean.Student> list = find.student(currPage, dept_name);
		request.setAttribute("list", list);
		if (count % myJavaBean.Student.PAGE == 0)
		{
			pages = count / myJavaBean.Student.PAGE;
		}
		else 
		{
			pages = count / myJavaBean.Student.PAGE + 1;
		}
		for (int i = 1; i <= pages; i++)
		{
			if (i == currPage)
			{
				sb.append("【" + i + "】");
			}
			else 
			{
				sb.append("<a href='Student?page=" + i +"&dept_name=" + dept_name + "'>" + i + "</a>");
			}
			sb.append(" ");
		}
		request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("findStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
