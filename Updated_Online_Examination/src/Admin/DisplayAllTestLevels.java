package Admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayAllTestLevels
 */
@WebServlet("/DisplayAllTestLevels")
public class DisplayAllTestLevels extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllTestLevels() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("Welcome to DisplayAllTestLevels.java");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc=request.getServletContext();
		
		String testname=request.getParameter("testname").toString();
		ArrayList<String> list=AdminDAO.Get_Admin_Test_Levels(testname);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table,tr,th,td{ border:1px solid red;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<table>");
		out.println("<tr><th>Levels</th><th>Insert?</th></tr>");
		for(String s:list)
		out.println("<tr><td>"+s+"</td><td><a href='SaveQuestions.jsp?level="+s.charAt(s.length()-1)+"&testname="+testname+"'><button>Enter Questions</button></a></td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}