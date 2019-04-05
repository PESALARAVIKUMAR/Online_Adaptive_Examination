<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="loginstyle.css">
<script>
var req;
function display()
{
	var url="DisplayAllAdmins.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
	req.onreadystatechange=function()
	{
	if(req.readyState==4)
	{
	var val=req.responseText;
	document.getElementById("id1").innerHTML=val;
	}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e) 
	{	
		alert("Unable to connect Server");
	}
}

</script>

</head>
<body class="bodystyle">
<div class="form-group required">
<%
String ownermail=request.getParameter("email");
String ownerpassword=request.getParameter("password");

if( (ownermail.equals("ravikumar1593575@gmail.com")) && (ownerpassword.equals("ravi1998")) )
{
%>
WELCOME OWNER <%=ownermail %>
<form name="f2" id="f2">
<input type="button" class="loginbutton" onclick="display()" value="Display Admins">
</form>
<br><span id="id1"></span>
<%	
}
else
{
	out.println("<script>alert('Wrong Credentials')</script>");
	request.getRequestDispatcher("Owner.jsp").include(request,response);
}
	
%>
</div>
</body>
</html>