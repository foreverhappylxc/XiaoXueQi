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
 * Servlet implementation class SelectTakes
 */
@WebServlet("/SelectTakes")
public class SelectTakes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTakes() {
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
		if (dept_name.equals("所有"))  count = find.findCount("teaches");
		else {
			count = find.findCount("take", "dept_name", dept_name);
		}
		if (request.getParameter("page") != null)
		{
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		List<myJavaBean.Take> list = find.take(currPage, dept_name);
		request.setAttribute("list", list);
		if (count % myJavaBean.Take.PAGE == 0)
		{
			pages = count / myJavaBean.Take.PAGE;
		}
		else 
		{
			pages = count / myJavaBean.Take.PAGE + 1;
		}
		for (int i = 1; i <= pages; i++)
		{
			if (i == currPage)
			{
				sb.append("【" + i + "】");
			}
			else 
			{
				sb.append("<a href='SelectTakes?page=" + i +"&dept_name=" + dept_name + "'>" + i + "</a>");
			}
			sb.append(" ");
		}
		request.setAttribute("bar", sb.toString());
		request.getRequestDispatcher("selectTakes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
