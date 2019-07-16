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
 * Servlet implementation class FindGrade
 */
@WebServlet("/FindGrade")
public class FindGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindGrade() {
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
		String[] split = dept_name.split("\\s+");
		String course_id = split[0];
		String course_order = split[2];
		String year = split[3];
		String season = split[4];
		
		int count;
		count = find.findCount("student", "dept_name", "course_id='" + course_id + "'" + " and course_order='" + course_order + "'"
				+ " and year='" + year + "'" + " and season='" + season + "'");
		if (request.getParameter("page") != null)
		{
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		List<myJavaBean.Grade> list = find.grade(currPage, course_id, course_order, year, season);
		request.setAttribute("list", list);
		if (count % myJavaBean.Grade.PAGE == 0)
		{
			pages = count / myJavaBean.Grade.PAGE;
		}
		else 
		{
			pages = count / myJavaBean.Grade.PAGE + 1;
		}
		for (int i = 1; i <= pages; i++)
		{
			if (i == currPage)
			{
				sb.append("【" + i + "】");
			}
			else 
			{
				sb.append("<a href='FindGrade?page=" + i +"&dept_name=" + dept_name + "'>" + i + "</a>");
			}
			sb.append(" ");
		}
		request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("modifyGrade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
