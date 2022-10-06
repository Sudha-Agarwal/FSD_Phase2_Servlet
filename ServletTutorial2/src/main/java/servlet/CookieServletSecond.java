package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class CookieServletSecond
 */
@WebServlet("/CookieServletSecond")
public class CookieServletSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServletSecond() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Cookie ck[] = request.getCookies();
		String usrname = null;
		
		if(ck != null) {
			for(Cookie cookie: ck) { 
				if(cookie.getName().equals("uname")) {
					usrname = cookie.getValue();
					pw.println("Hello " + usrname);
				
				}
			}
		}
		
		if(usrname == null) {
			pw.println("Your session has timed out. Please login again");
			RequestDispatcher rd = request.getRequestDispatcher("cookieLogin.html");
			rd.include(request, response);
			//response.sendRedirect("cookieLogin.html");
			
		}
		
		//pw.println("Hello " + usrname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
