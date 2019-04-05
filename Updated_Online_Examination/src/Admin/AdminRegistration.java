package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminRegistration
 */
@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Admin a=new Admin();
		a.setName(request.getParameter("name"));
		a.setOrganization(request.getParameter("organization"));
		a.setEmail(request.getParameter("email"));
		a.setContact(request.getParameter("contact"));
		a.setPassword(request.getParameter("password"));
		
		int status=AdminDAO.Store_Admin(a);
		int s=AdminDAO.Create_Admin_Database(a);
		AdminDAO.Create_Admin_TestTable(a.getEmail()); 
		AdminDAO.Create_Admin_StudentTable(a.getEmail());
		// DEFAULT TestTable= create table admintests(tests varchar(100));
		// DEFAULT StudentTable= create table studentdetails();
		if(status+s>1)
		{
			out.println("<script>alert('Registration Successfull')</script>");
			request.getRequestDispatcher("Admin_Login_Signup.jsp").include(request, response);
		}
		else
		{
			out.println("<script>alert('Enter Valid Credentials to Register')</script>");
			request.getRequestDispatcher("Admin_Login_Signup.jsp").include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}