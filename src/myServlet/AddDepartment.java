package myServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myJavaBean.ModifyTable;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartment() {
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
		ModifyTable ad = new ModifyTable();
		request.setCharacterEncoding("utf-8");
		String dept_name = request.getParameter("dept_name");
		String building = request.getParameter("building");
		String president = request.getParameter("president");
		String vice_president = request.getParameter("vice_president");
		String description = request.getParameter("description");
		
		boolean success = ad.addDepartment(dept_name, building, president, vice_president, description);
		request.setAttribute("success", success);
		request.getRequestDispatcher("addDepartment.jsp").forward(request, response);
	}

}
