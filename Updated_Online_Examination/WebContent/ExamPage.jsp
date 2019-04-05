<%@page import="Admin.AdminDAO"%>
<%@page import="org.omg.CORBA.portable.ApplicationException"%>
<%@page import="Questions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Page</title>
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
<div class="form-group required">
<ul>
  <li ><a class="active" href="StudentLogin.jsp"><button onclick="noback()">Logout</button></a></li>
</ul>
<form action="CheckAnswer" method="post">
<%
int level=Integer.parseInt(application.getAttribute("level").toString());
int db_que_no=Integer.parseInt(application.getAttribute("db_que_no").toString());
application.setAttribute("db_que_no",db_que_no);
Questions q=AdminDAO.GetQuestion(application.getAttribute("test_name").toString(), level, db_que_no);
%>
Question <%=application.getAttribute("no")%>:<br>
<%=q.getQue() %><br>
<br><input type="radio" name="ans" value="<%=q.getO1() %>"><%=q.getO1() %>
<br><input type="radio" name="ans" value="<%=q.getO2() %>"><%=q.getO2() %>
<br><input type="radio" name="ans" value="<%=q.getO3() %>"><%=q.getO3() %>
<br><input type="radio" name="ans" value="<%=q.getO4() %>"><%=q.getO4() %>
<br><input type="submit" value="Submit">
</form>
</div>
</body>
</html>