<%@page import="Admin.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String testname=request.getParameter("testname").toString();
String admin=application.getAttribute("admin_email").toString();
int s=0;
if (AdminDAO.Delete_Test_From_Admin(admin,testname)>0) s+=1;

if((AdminDAO.Drop_Test_Database(testname)>0) && (s>0)) s+=1;

if(s>1)
{
	out.println("<script>alert('Dropped Test Successfully')</script>");
	request.getRequestDispatcher("Admin_HomePage.jsp").include(request,response);
}
else
{
	out.println("<script>alert('Error in Dropping Test')</script>");
	request.getRequestDispatcher("Admin_HomePage.jsp").include(request,response);
}
%>
</body>
</html>