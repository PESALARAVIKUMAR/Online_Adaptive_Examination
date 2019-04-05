<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DisplayQuestions</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="Admin_HomePageStyling.css">
<script>
var req;
function display()
{
	var testname=document.getElementById("testname").value;
	var level=document.getElementById("level").value;
	var url="DisplayAllQuestions?level="+level+"&testname="+testname;
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
	req.onreadystatechange=function()
	{
	if(req.readyState==4)
	{
	var val=req.responseText;
	document.getElementById("id").innerHTML=val;
	}
	}
	req.open("POST",url,true);
	req.send(null);
	}
	catch(e) {	alert("Unable to connect Server");}
}
</script>
</head>
<body class="bodystyle">
<div clas="bodystyle1">

<ul>
  <li ><a class="active" href="Admin_Login_Signup.jsp">Logout</a></li>
  <li ><a class="active" href="SaveQuestions.jsp">Save Questions</a></li>
  <li ><a class="active" href="Admin_HomePage.jsp">HomePage</a></li>
</ul>

<h2 style="text-align:center;">Search Questions in Levels with TestName</h2>
<form name="f2" id="f2">
<label class='control-label'>Enter TestName:</label><br><input type="text" class="input" name="testname" id="testname"><br>
<label class='control-label'>Enter Level:</label><br><input type="text" class="input" name="level" id="level"><br>
<input type="button" class="loginbutton" onclick="display()" value="Display Questions">
</form>
</div>
<br>
<br>
<span id="id"></span>
</body>
</html>