<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="Admin.*" %>
    <%@ page import="Questions.*" %>
    <%@ page import="Student.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<body class="bodystyle">
<div class="form-group required">

<%
String testname=request.getParameter("test");

String key="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
String examkey="";
for(int i=0;i<10;i++)
{
	int rk=new Random().nextInt(key.length());
	examkey=examkey+key.charAt(rk);
}
System.out.println(examkey);

ServletContext sc=request.getServletContext();
sc.setAttribute("examkey",examkey);
application.setAttribute("test_name",testname);
sc.getAttribute("student_email");

request.getRequestDispatcher("SendMail").include(request,response); 
%>
<%
application.setAttribute("level",1);
application.setAttribute("present_que_no",1);
application.setAttribute("db_que_no",1);

Student s=AdminDAO.Get_Student_From_Admin_Database(sc.getAttribute("test_admin").toString(), sc.getAttribute("student_email").toString());
%>
<b><i>
<label class='control-label'>WELCOME</label> <br> <%=s.getFirstname() %> <%=s.getLastname() %><br><br>
<table>
<tr>
<th>Name</th><th>Date of Birth</th><th>Phone</th><th>Gender</th><th>Email Id</th>
</tr>
<tr>
<td><%=s.getFirstname() %> <%=s.getLastname() %></td><td><%=s.getDob() %></td><td><%=s.getGender() %></td><td><%=s.getPhone() %></td><td><%=s.getEmail()%></td>
</tr>
</table>

</i></b>
<br><form id="loginform" action="ValidateExamKey" method="post">
<label class='control-label'>Enter ExamKey:</label><br><input type="text" class="input" name="examkey" id="examkey"><br>
<br><input type="submit" class="submitbutton" value="Take Test">
</form>
</div>
</body>
</html>