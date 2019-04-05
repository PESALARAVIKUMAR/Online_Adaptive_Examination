<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin_Login_Signup</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<body class="bodystyle">
<div class="bodystyle1">
<form name="Login" id="Login" action="AdminValidation" method="post">
<h1 style="text-align:center;">  ADMIN LOGIN</h1>
<label class='control-label'>Email</label><br><input type="email" maxlength="50" class="input" placeholder="Enter Email" name="email" id="email"/><br>
<label class='control-label'>Password</label><br><input type="password" maxlength="50" class="input" placeholder="Enter Password" name="password" id="password"/><br>
<br><input type="submit" class="loginbutton"  value="LOGIN"  /><br>
</form>

<form name="Signup" id="Signup" action="AdminRegistration" method="post">
<h1 style="text-align:center;">  ADMIN REGISTRATION</h1>
<label class='control-label'>Name</label><br><input type="text" maxlength="50" class="input" placeholder="Enter Name" name="name" id="name"/><br>
<label class='control-label'>Organization</label><br><input type="text" maxlength="50" class="input" placeholder="Enter Organization" name="organization" id="organization"/><br>
<label class='control-label'>Email</label><br><input type="email" maxlength="50" class="input" placeholder="Enter Email" name="email" id="email"/><br>
<label class='control-label'>Contact</label><br><input type="text" maxlength="50" class="input" placeholder="Enter Contact" name="contact" id="contact"/><br>
<label class='control-label'>Password</label><br><input type="password" maxlength="50" class="input" placeholder="Enter Password" name="password" id="password"/><br>
<br><input type="submit" class="loginbutton"  value="REGISTER"  /><br>
</form>
</div>
</body>
</html>