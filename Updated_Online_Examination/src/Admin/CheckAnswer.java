package Admin;
import Questions.*;

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
 * Servlet implementation class CheckAnswer
 */
@WebServlet("/CheckAnswer")
public class CheckAnswer extends HttpServlet 
{
	int answered=0;
	ArrayList<Questions>listt=new ArrayList<Questions>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnswer() {
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
		ServletContext sc=request.getServletContext();
		
		int level=Integer.parseInt(sc.getAttribute("level").toString());
		//System.out.println("level is "+level);
		
		int present_que_no=Integer.parseInt(sc.getAttribute("no").toString());
		//System.out.println("Present que in level "+level+"is "+present_que_no);
		
		String answer=request.getParameter("ans");
		//System.out.println("Answer is "+answer);
		
		int db_que_no=Integer.parseInt(sc.getAttribute("db_que_no").toString());
		//System.out.println("db_que_no is "+db_que_no);
		
		Questions q=AdminDAO.GetQuestion(sc.getAttribute("test_name").toString(), level, db_que_no);
		//System.out.println("Expected ans is "+q.getAns());
		listt.add(q);
		sc.setAttribute("questions",listt);
		if(answer.equals(q.getAns()))
		{
			//out.println("<script>alert('Correct')</script>");
			answered+=1;
			sc.setAttribute("answered",answered);
			present_que_no+=1;
			level+=1;			
			sc.setAttribute("db_que_no",1);
			sc.setAttribute("level",level);
			sc.setAttribute("present_que_no",present_que_no);
			request.getRequestDispatcher("ControllerPage.jsp").include(request,response);
		}
		else
		{
			//out.println("<script>alert('Incorrect')</script>");
			sc.setAttribute("answered",answered);
			present_que_no+=1;
			db_que_no+=1;
			sc.setAttribute("db_que_no",db_que_no);
			sc.setAttribute("level",level);
			sc.setAttribute("present_que_no",present_que_no);
			request.getRequestDispatcher("ControllerPage.jsp").include(request,response);
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