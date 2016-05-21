

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL;
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
		
		if (isValid(user.getUserName(), "password")){
			nextURL="/home.jsp";
			request.setAttribute("username", user.getUserName());
			request.setAttribute("email", user.getEmail());
		} else {
			nextURL="/error.html";
		}
		

		request.getRequestDispatcher(nextURL).forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	boolean isValid(String username,  String password){
		if (username.equals("richard") && password.equals("password")){
			return true;
		}else{
			return false;
		}
	}

}
