package Admin;
import Questions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayAllQuestions
 */
@WebServlet("/DisplayAllQuestions")
public class DisplayAllQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllQuestions() {
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
		
		String level=request.getParameter("level").toString();
		String testname=request.getParameter("testname").toString();
		//System.out.println(level);
		//System.out.println(testname);
		
		ArrayList<Questions> list=new ArrayList<Questions>();
		list=AdminDAO.Get_All_Questions(testname, level);
		out.println("LEVEL "+level);
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table,tr,th,td{ border:1px solid red;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th>No</th><th>Question</th><th>Option 1</th><th>Option 2</th><th>Option 3</th><th>Option 4</th><th>Answer</th></tr>");
		for(Questions q:list)
		{
			out.println("<tr><td>"+q.getNo()+"</td><td>"+q.getQue()+"</td><td>"+q.getO1()+"</td><td>"+q.getO2()+"</td><td>"+q.getO3()+"</td><td>"+q.getO4()+"</td><td>"+q.getAns()+"</td></tr>");
		}
		out.println("</table>");
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