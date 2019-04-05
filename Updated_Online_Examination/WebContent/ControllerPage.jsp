<%@page import="Admin.AdminDAO"%>
<%@page import="Questions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controller Page</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="Admin_HomePageStyling.css">
<script>
function noback()
{
	window.history.forward();
}
setTimeout("noback()",10);
</script>
</head>
<body class="bodystyle">
<div class="bodystyle1">
<ul>
  <li ><a class="active" href="StudentLogin.jsp"><button onclick="noback()">Logout</button></a></li>
</ul>
<%
int l=0;
ServletContext sc=request.getServletContext();
ArrayList<String> list=AdminDAO.Get_Admin_Test_Levels(application.getAttribute("test_name").toString());
for(String s:list) l+=1;
int level=Integer.parseInt(application.getAttribute("level").toString());
int present_que_no=Integer.parseInt(application.getAttribute("present_que_no").toString());
if(present_que_no<=10)
{
	if(level==l) level=1;
	application.setAttribute("no",present_que_no);
	application.setAttribute("level",level);
	
	//int[] a=QuestionsDAO.GetAllQuestionsNumbers(level);
	//Random gen=new Random();
	//int random_index=gen.nextInt(a.length);
	//if(a[random_index]==0) a[random_index]+=1;
	//application.setAttribute("db_que_no",a[random_index]);
	
	int db_que_no=Integer.parseInt(application.getAttribute("db_que_no").toString());
	application.setAttribute("db_que_no",db_que_no);
	request.getRequestDispatcher("ExamPage.jsp").include(request,response);
}
else
{
	out.println("<script>alert('Exam End Successfully Check Marks in Mail')</script>");
	sc.setAttribute("examkey",sc.getAttribute("answered").toString());
	request.getRequestDispatcher("SendMail").include(request,response);
}
%>
</div>
</body>
</html>