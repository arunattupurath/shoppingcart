<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="loginForm" method="post" action="/login" >
							<div id="usernameDiv">
								<input id="username" name="username" />
							</div>
							<div id="passwordDiv">
								<input id="password" name="password" />
							</div>
							
							<input type="submit" title={"LOGIN"} btnstyle={"primary"} className="btn-block login-button" />
						</form>
</body>
</html>