<%@ page import="Admin.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@ page import="Admin.*" %>
<%@ page import="java.util.*;"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="loginstyle.css">

<script type="text/javascript" src="ValidateRegistration.js"></script> 

<title>Registration</title>

</head>

<body class="bodystyle">

<div class="form-group required">

<h1 style="text-align:center;">  STUDENT REGISTRATION</h1>

<form name="Registration" id="loginform"  action="Student_Registration" onsubmit="return validate(this)"  method="post">

<label class='control-label'>First Name</label><input type="text" maxlength="50" class="input" placeholder="First Name" name="fn" id="firstname"/><br>

<label class='control-label'>Last Name</label><input type="text" maxlength="50" class="input" placeholder="Last Name" name="ln" id="lastname"/><br>

<label class='control-label'>Date of Birth</label><input type="text" maxlength="10" class="input" placeholder="Date of Birth" name="dob" id="dob"/><br>

<label class='control-label' > Age</label><input type="number" maxlength="2" SIZE="2"class="input" placeholder="Age" name="age" id="age"/><br>

<label class='control-label'>Gender</label><select class="input dropdown1" name="gender">

                                    <option value="Male">Male</option>

                                    <option value="Female">Female</option>

                                    </select><br>

<label class='control-label'>Contact Number</label><input type="text" maxlength="10" class="input" placeholder="Contact Number" name="phone" id="contact"/><br>

<label class='control-label'>Email ID</label><input type="text" maxlength="50" class="input" placeholder="Email ID" name="email" id="email"/><br>

<label class='control-label'>Password</label><input type="password" maxlength="15" class="input" placeholder="Password" name="password1" id="password1"/><br>

<label class='control-label'>Re-Enter Password</label><input type="password" maxlength="15" class="input" placeholder="Re-Enter Password" name="password2" id="password2"/><br>

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

<input type="submit" class="loginbutton"  value="SIGN UP"  /><br>

</form>

 
</div>
</body>

</html>