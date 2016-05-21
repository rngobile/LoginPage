

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Custom Classes

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Grab Session and add to User Class
		HttpSession session = request.getSession();
		User user = new User();
		
		//Retrieve username, email from GET call
		user.setUserName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		
		session.setAttribute("user", user);
				
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println(user.getUserName());
		
		String nextURL="/home.jsp";
		request.setAttribute("username", user.getUserName());
		request.setAttribute("email", user.getEmail());
		request.getRequestDispatcher(nextURL).forward(request, response);
		
		
		//Write to page using GET call
		//PrintWriter out = response.getWriter();
		//out.println(request.getParameter("username"));
		
		//Redirecting to new page
		//String nextURL = "/login.jsp";
		//getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
		
}
