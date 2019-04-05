<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Admin Home Page</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="Admin_HomePageStyling.css">
<script type="text/javascript">
function validate1()
{
	var testname=document.getElementById("testname").value();
	var level=document.getElementById("testlevel").value();
	
	if(testname=="")
		{
			alert('Enter TestName');
			document.getElementById("testname").style.borderColor="red";
			return false;
		}
	if(level=="" || level.matches("[0-9]"))
		{
			alert('Enter Appropriate Level Format');
			document.getElementById("testlevel").style.borderColor="red";
			return false;
		}
	return true;
}

function validate2()
{
	var testname=document.getElementById("testname").value();
	if(testname=="")
	{
		alert('Enter TestName');
		document.getElementById("testname").style.borderColor="red";
		return false;
	}
	return true;
}

var req2;
function display2()
{
	var testname=document.f2.testname.value;
	var url="DisplayAllTestLevels?testname="+testname;
	if(window.XMLHttpRequest) req2=new XMLHttpRequest();
	else if(window.ActiveXObject) req2= new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req2.onreadystatechange=function()
		{
			if(req2.readyState==4)
				{
				var val=req2.responseText;
				document.getElementById("id").innerHTML=val;
				}
		}
		req2.open("POST", url, true);
		req2.send(null)
	}
	catch(e)
	{
		alert("Unable to Connect Server");
	}
}

var req3;
function display3()
{
	var url="DisplayAllTests";
	if(window.XMLHttpRequest) req3=new XMLHttpRequest();
	else if(window.ActiveXObject) req3= new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req3.onreadystatechange=function()
		{
			if(req3.readyState==4)
				{
				var val=req3.responseText;
				document.getElementById("id").innerHTML=val;
				}
		}
		req3.open("POST", url, true);
		req3.send(null)
	}
	catch(e)
	{
		alert("Unable to Connect Server");
	}
}
</script>
</head>
<body class="bodystyle">

<div class="bodyStyle1">
<% 
Admin a=(Admin)application.getAttribute("admin_object");
application.getAttribute("admin_email").toString();
%>
<h2 style="text-align:center;">Welcome <%= a.getName() %></h2>
<br>
<ul>
  <li ><a class="active" onclick="f1()" href="Admin_Login_Signup.jsp">Logout</a></li>
  <li ><a class="active" onclick="f2()" href="DisplayQuestions.jsp">Display Questions</a></li>
  <li ><a class="active" onclick="f3()" href="SaveQuestions.jsp">Save Questions</a></li>
</ul>
<br>
<br>

<center>
<div class="inner">
<form name="f3">
<input type="button" class="loginbutton" onclick="display3()" value="View Tests"  /><br>
</form>
</div>

<div class="inner">
<form name="f2" onclick="return validate2(this)" id="f2">
<label class='control-label'>Enter Test Name to Display Levels</label><br><input type="text" name="testname" class="input" id="testname" placeholder="Enter Test Name"><br>
<input type="button" class="loginbutton" onclick="display2()" value="View Test Levels"  /><br>
</form>
</div>

<div class="inner">
<form name="f1" onclick="return validate1(this)" action="CreateTest" method="post" id="f1">
<label class='control-label'>Enter Test Name to Create New Test</label><br><input type="text" name="testname" class="input" id="testname" placeholder="Enter Test Name"><br>
<label class='control-label'>Enter Number of Levels to be in Test</label><br><input type="text" name="testlevel" class="input" id="testlevel" placeholder="Enter Number of Levels"><br>
<input type="submit" class="loginbutton"  value="Create New Test"  /><br>
</form>
</div>

</center>

<span id="id"></span>
</body>
</html>