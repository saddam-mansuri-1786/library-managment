package book.mgmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.mgmt.dao.UserDao;
import book.mgmt.dao.UserDaoImpl;
import book.mgmt.entity.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		
		User user = new User(username,password);
		UserDao userDao = new UserDaoImpl();
		
		try {
			int result = userDao.registerUser(user);
			
			if(result > 0) {
				response.sendRedirect("login.jsp?message=Registration Successful.Login to continue");
			}else {
				response.sendRedirect("registration.jsp?message=Registration failed ! Try again.");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			response.sendRedirect("registration.jsp?message=OOPs!! something went wrong  ");
			
			e.printStackTrace();
		}
	}

}
