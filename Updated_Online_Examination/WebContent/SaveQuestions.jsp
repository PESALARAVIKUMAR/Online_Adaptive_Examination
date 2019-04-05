<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="Admin.*;" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Questions</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="Admin_HomePageStyling.css">
<script>
function validate1() 
{
	var level=document.getElementById("level").value;
	var queno=document.getElementById("no").value;
	var que=document.getElementById("que").value;
	var o1=document.getElementById("o1").value;
	var o2=document.getElementById("o2").value;
	var o3=document.getElementById("o3").value;
	var o4=document.getElementById("o4").value;
	var ans=document.getElementById("ans").value;
	
	if((level == "") || (level.matches("[1-10]{1}")))
	{
        alert('Please Enter Valid Level');
        document.getElementById('level').style.borderColor = "red";
        return false;
    }
	
	if(queno == "")
	{
        alert('Please Enter Question Number');
        document.getElementById('no').style.borderColor = "red";
        return false;
    }
	
	if(que.equals(""))
	{
        alert('Please Enter Question');
        document.getElementById('que').style.borderColor = "red";
        return false;
    }
	
	if(o1 == "")
	{
        alert('Please Enter Option 1');
        document.getElementById('o1').style.borderColor = "red";
        return false;
    }
	
	if(o2 == "")
	{
        alert('Please Enter Option 2');
        document.getElementById('o2').style.borderColor = "red";
        return false;
    }
	
	if(o3 == "")
	{
        alert('Please Enter Option 3');
        document.getElementById('o3').style.borderColor = "red";
        return false;
    }
	
	if(o4 == "")
	{
        alert('Please Enter Option 4');
        document.getElementById('o4').style.borderColor = "red";
        return false;
    }
	
	if(ans == "")
	{
        alert('Please Enter Answer');
        document.getElementById('ans').style.borderColor = "red";
        return false;
    }
	return true;
}


function validate2()
{
	var level=document.getElementById("level1").value;
	if((level == "") || (level.matches("[1-10]{1}")))
	{
        alert('Please Enter Valid Level');
        document.getElementById('level1').style.borderColor = "red";
        return false;
    }
}

</script>
</head>
<body class="bodystyle">
<ul>
  <li ><a class="active" href="Admin_Login_Signup.jsp">Logout</a></li>
  <li ><a class="active" href="DisplayQuestions.jsp">Display Questions</a></li>
  <li ><a class="active" href="Admin_HomePage.jsp">HomePage</a></li>
</ul>
<div class="form-group required">
<h2 style="text-align:center;">Enter Questions to Store</h2>
<form name="f1" action="SaveQuestions" method="post">
<label class='control-label'>Enter TestName:</label><br><input type="text" class="input" name="testname" id="testname" placeholder="<%=request.getParameter("testname") %>"><br>
<label class='control-label'>Enter Level:</label><br><input type="text" class="input" name="level" id="level" placeholder="<%=request.getParameter("level") %>"><br>
<label class='control-label'>Enter Question Number:</label><br><input type="text" class="input" name="no" id="no"><br>
<label class='control-label'>Enter Question:</label><br><input type="text" class="input" name="que" id="que" style="width:600px;"><br>
<label class='control-label'>Option1:</label><br><input type="text" class="input" name="o1" id="o1"><br>
<label class='control-label'>Option2:</label><br><input type="text" class="input" name="o2" id="o2"><br>
<label class='control-label'>Option3:</label><br><input type="text" class="input" name="o3" id="o3"><br>
<label class='control-label'>Option4:</label><br><input type="text" class="input" name="o4" id="o4"><br>
<label class='control-label'>Answer:</label><br><input type="text" class="input" name="ans" id="ans"><br>
<br><input type="submit" class="loginbutton" value="Save">
<input type="reset" class="loginbutton" value="Reset">
</form>

</div>
</body>
</html>