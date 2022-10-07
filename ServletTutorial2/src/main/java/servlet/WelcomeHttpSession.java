package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeHttpSession
 */
@WebServlet("/WelcomeHttpSession")
public class WelcomeHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeHttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(false);	
		
		if(session != null) {
			
			String user = (String)session.getAttribute("user");
			pw.println("Hello " + user);
			pw.println("<br>Session Id: " + session.getId());
			pw.println("<br>Session creation Time: " + new Date(session.getCreationTime()));
			pw.println("<br>Last Accessed Time " + new Date(session.getLastAccessedTime()));
			pw.println("<br>Max inactive interval: " + session.getMaxInactiveInterval());
			session.setMaxInactiveInterval(10);
		}	
		
	}

}
