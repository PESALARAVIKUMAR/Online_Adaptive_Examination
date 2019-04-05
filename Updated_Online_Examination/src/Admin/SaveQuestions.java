package Admin;
import Questions.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveQuestions
 */
@WebServlet("/SaveQuestions")
public class SaveQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveQuestions() {
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
		
		String testname=request.getParameter("testname");
		String level=request.getParameter("level");
		int no=Integer.parseInt(request.getParameter("no"));
		String que=request.getParameter("que");
		String o1=request.getParameter("o1");
		String o2=request.getParameter("o2");
		String o3=request.getParameter("o3");
		String o4=request.getParameter("o4");
		String ans=request.getParameter("ans");
		Questions q=new Questions();
		q.setLevel(level);
		q.setNo(no);
		q.setQue(que);
		q.setO1(o1);
		q.setO2(o2);
		q.setO3(o3);
		q.setO4(o4);
		q.setAns(ans);
		
		//System.out.println(testname);
		//System.out.println(level);
		
		int status=AdminDAO.Insert_Questions(testname, level, q);
		if(status>0)
		{
			out.println("<script>alert('Saved Successfully')</script>");
			request.getRequestDispatcher("SaveQuestions.jsp").include(request,response);
		}
		else
		{
			out.println("<script>alert('ErroR in Saving')</script>");
			request.getRequestDispatcher("SaveQuestions.jsp").include(request,response);
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