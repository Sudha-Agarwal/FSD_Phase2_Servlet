package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.EmployeeDAO;
import bean.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		List<Employee> list = EmployeeDAO.getAllEmployeesCallable();
		
		pw.println("<table border='1' width='100%'>");
		
		pw.println("<tr><th>First Name</th><th>Last Name</th></tr>");
		
		for(Employee e:list) {
			pw.println("<tr><td>" + e.getFirstName() + "</td><td>" 
					+ e.getLastName() + "</td></tr>");
		}
		
		pw.print("</table>");	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		Employee e = EmployeeDAO.getEmployeeById(id);
		
		pw.println("<table border='1' width='100%'>");
		
		pw.println("<tr><th>First Name</th><th>Last Name</th></tr>");
		
		
			pw.println("<tr><td>" + e.getFirstName() + "</td><td>" 
					+ e.getLastName() + "</td></tr>");
		
		
		pw.print("</table>");
	}

}
