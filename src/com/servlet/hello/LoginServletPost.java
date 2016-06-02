package com.servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServletPost")
public class LoginServletPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServletPost() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextURL;

		String action = request.getParameter("action");

		// Grab Session and add to User Class
		HttpSession session = request.getSession();
		User user = new User();

		// Retrieve username, email from GET call
		user.setUserName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));

		session.setAttribute("user", user);

		String username = user.getUserName();
		String email = user.getEmail();

		if (action == null) {
			action = "";
		} else if (username == null || email == null) {
			username = "";
			email = "";
		}

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println(user.getUserName());

		if (action.equals("logout")) {
			session.invalidate();
			nextURL = "/login.html";
		} else {
			if (isValid(user.getUserName(), "password")) {
				nextURL = "/home.jsp";
				request.setAttribute("username", username);
				request.setAttribute("email", email);
			} else {
				nextURL = "/error.html";
			}
		}
		request.getRequestDispatcher(nextURL).forward(request, response);
		//show url path
		//response.sendRedirect(request.getContextPath() + nextURL);
	}

	boolean isValid(String username, String password) {
		if (username.equals("richard") && password.equals("password")) {
			return true;
		} else {
			return true; //false;
		}
	}

}
