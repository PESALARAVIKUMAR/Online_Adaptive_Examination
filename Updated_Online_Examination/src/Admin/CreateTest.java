package Admin;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateTest
 */
@WebServlet("/CreateTest")
public class CreateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTest() {
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
		ServletContext sc=request.getServletContext();
		
		String testname=request.getParameter("testname").toString();
		int level=Integer.parseInt(request.getParameter("testlevel").toString());
		
		Admin a=AdminDAO.Get_Admin_Details(sc.getAttribute("admin_email").toString());
		
		int s=0;
		if(AdminDAO.Create_Test_Database(testname)>0) s+=1;
		else out.println("<script>alert('Error in Creating Test Database')</script>");
			
		if ((AdminDAO.Insert_Into_Admin_TestTable(a, testname)>0)) s+=1;
		else out.println("<script>alert('Error in Inserting into Admin Test Table')</script>");
			
		if((AdminDAO.Create_Test_Level_Tables(testname,level)>0)) s+=1;
		else out.println("<script>alert('Error in Creating Test Level Tables')</script>");
		
		if(s>2)
		{
			sc.setAttribute("testname",testname);
			sc.setAttribute("testlevel",level);
			out.println("Created Successfully");
			request.getRequestDispatcher("SaveQuestions.jsp").include(request, response);
		}
		else
		{
			out.println("<script>alert('Error in Creating Test')</script>");
			request.getRequestDispatcher("Admin_HomePage.jsp").include(request, response);
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