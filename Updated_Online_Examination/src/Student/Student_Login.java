package Student;
import Questions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.ApplicationException;

import Admin.Admin;
import Admin.AdminDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Student_Login")
public class Student_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc= request.getServletContext();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String admin=request.getParameter("admin");
		
		Admin a=AdminDAO.Get_Admin_Details_By_Name(admin);
		sc.setAttribute("test_admin",a.getEmail());
		Student s=AdminDAO.Get_Student_From_Admin_Database(a.getEmail(),email);
		
		if((email.equals(s.getEmail()))&&(password.equals(s.getPassword())))
		{
			sc.setAttribute("student_email",email);			
			request.getRequestDispatcher("Tests_By_Admin.jsp").forward(request,response);
		}
		else
		{
			System.out.println("Wrong Credentials");
			request.getRequestDispatcher("StudentLogin.jsp").include(request,response);
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