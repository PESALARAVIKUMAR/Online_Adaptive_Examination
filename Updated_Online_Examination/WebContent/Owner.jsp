<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Login</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<body class="bodystyle">
<div class="bodystyle1">
<h1 style="text-align:center; ">ONLINE EXAMINATION SYSTEM</h1>
<br>
<form id="loginform"  action="OwnerValidation.jsp" method="post">
<label>Email Id</label>
<br>
<input type="email" class="input" placeholder="Email Id" name="email" /> <br>
<label>Password</label>
<br>
<input type="password" class="input" placeholder="Password" name="password" />
<input type="submit" class="loginbutton" value="LOGIN" />
</form>
</div>
</body>
</html>