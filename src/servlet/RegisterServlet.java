package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import backEnd.ConnectMySQL;
import backEnd.RegisterDAO;
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
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String cu_img="";
		
		int cu_age =Integer.parseInt(age);
		int  cu_qq = Integer.parseInt(qq);
		int cu_credit=0;
		String cu_authority="一般权限";
		
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			Customer user=new Customer();
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if(item.isFormField()) {
					String filename=item.getFieldName();
					String value=item.getString("utf-8");
				}else {
					String filename=item.getName();
					System.out.println("文件"+filename);
					String suffix=filename.substring(filename.lastIndexOf('.'));
					UUID uuid=UUID.randomUUID();
					String prefix=uuid.toString();
					String savefilename=prefix+suffix;
					savefilename=savefilename.replace("-", "");
					String path=servletContext.getRealPath("/userimage");
					user.setCu_img(savefilename);
					cu_img=savefilename;
					System.out.println("path"+path);
					InputStream is=item.getInputStream();
					OutputStream os=new FileOutputStream(new File(path+File.separator+savefilename));
					byte[] b=new byte[1024];
					int len;
					while((len=is.read(b))!=-1) {
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
			}
			System.out.println("Password"+user.getCu_pwd());
			 
		ConnectMySQL customerregister = new ConnectMySQL();
		RegisterDAO dao=new RegisterDAO();
		try {
			Connection connection=customerregister.conn;
			if(dao.register(connection, user)) {
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} catch (FileUploadException e) {
		e.printStackTrace();
	}
	}
}