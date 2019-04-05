<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Admin.*" %>
    <%@ page import="java.util.*;"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="loginstyle.css">
<title>Login</title>
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
<h1 style="text-align:center; ">ONLINE EXAMINATION SYSTEM</h1>
<br>
<form id="loginform"  action="Student_Login" method="post">
<label>Email Id</label>
<br>
<input type="email" class="input" placeholder="Email Id" name="email" /> <br>
<label>Password</label>
<br>
<input type="password" class="input" placeholder="Password" name="password" />

<label class='control-label'>Select Admin</label><select class="input dropdown1" name="admin">
<%
ArrayList<Admin> list=AdminDAO.Get_Admin_Details();
for(Admin a:list)
{
%>
<br><option value="<%=a.getName()%>"><%=a.getName()%></option>
<%
}
%>
</select>


<input type="submit" class="loginbutton" onclick="noback()" value="LOGIN" />
</form>
</div>
<a href="StudentRegistration.jsp">Register Here</a>
</body>
</html>