package Student;
import Questions.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Admin.Admin;
import Admin.AdminDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Student_Registration")
public class Student_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc= request.getServletContext();
		
		Student s =new Student();
		s.setFirstname(request.getParameter("fn"));
		s.setLastname(request.getParameter("ln"));		
		s.setDob(request.getParameter("dob"));
		s.setAge(Integer.parseInt(request.getParameter("age")));
		s.setGender(request.getParameter("gender"));
		s.setPhone(request.getParameter("phone"));
		s.setEmail(request.getParameter("email"));		
		s.setPassword(request.getParameter("password1"));
		
		String admin=request.getParameter("admin").toString();
		sc.setAttribute("test_admin",admin);
		
		Admin a=AdminDAO.Get_Admin_Details_By_Name(admin);
		sc.setAttribute("test_admin_email",a.getEmail());
		int staus= AdminDAO.Save_Student_Into_Admin_Database(a.getEmail(), s);
		
		if(staus>0)
		{
			sc.setAttribute("student_name", s.getFirstname()+s.getLastname());
			sc.setAttribute("student_email",s.getEmail());
			out.println("<script>alert('Saved Successfully')</script>");
			request.getRequestDispatcher("StudentLogin.jsp").include(request,response);
		}
		else
		{
			out.println("<script>alert('Errorr In Saving Student')</script>");
			request.getRequestDispatcher("StudentRegistration.jsp").include(request,response);
		}
		}
		catch(Exception e)
		{
			System.out.println("Error in Registration.java "+e);
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