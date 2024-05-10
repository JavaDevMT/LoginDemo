package com.user.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class HelloWorld
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			PreparedStatement statement = connection
					.prepareStatement("insert into user value(?,?,?,?,?)");
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.setString(4, userName);
			statement.setString(5, password);
			int result = statement.executeUpdate();
			
		HttpSession session = request.getSession();
		if (result>0) {
			session.setAttribute("reguser", firstName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("regSuccessPage");
			requestDispatcher.forward(request, response);
		} else {
			session.setAttribute("error", "Failed registration");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userRegistration");
			requestDispatcher.forward(request, response);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

}

}
