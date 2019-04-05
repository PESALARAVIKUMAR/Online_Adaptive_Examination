<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tests By Admin</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<body class="bodystyle">
<div class="bodystyle1">

<label class='control-label'>Select Test</label>
<form action="HomePage.jsp">
<%
application.getAttribute("student_email");
application.getAttribute("test_admin");

ArrayList<String> list=AdminDAO.Get_Admin_Tests(application.getAttribute("test_admin").toString());
for(String a:list)
{
%>
<br><input type="radio" name="test" value="<%=a %>" id="test"/><%=a %>
<%
}
%>
</select>

<br><input type="submit" value="taketest">
</form>
</div>
</body>
</html>