package jUnit.test;

import static org.easymock.EasyMock.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myServlet.LogIn;

public class TLogIn {
	private LogIn login;
	Class<LogIn> c;
	Method method;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Before
	public void setUp() {
		login = new LogIn();
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
	}
	
	@After
	public void tearDown() throws Exception {
		verify(request);
		verify(response);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		c = LogIn.class;
		try {
			request.setCharacterEncoding("utf-8");
			request.getParameter("userName");
			expectLastCall().andReturn("2017");
			request.getParameter("password");
			expectLastCall().andReturn("345678");
			request.getParameter("type");
			expectLastCall().andReturn("manager");
			request.getParameter("js");
			expectLastCall().andReturn("true");
			replay(request);
			replay(response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			method = c.getDeclaredMethod("doPost", new Class[] {HttpServletRequest.class, HttpServletResponse.class});
			method.setAccessible(true);
			try {
				method.invoke(login, new Object[] {request, response});
				method.setAccessible(false);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
