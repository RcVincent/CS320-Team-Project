<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<style type = "text/css">
		.error {
			color: red;
		}
		
		</style>
</head>

<body>

<form action="${pageContext.servletContext.contextPath}/User" method="post">
Employee Number: <input type ="text" name="UserID"><br>
First Name: <input type="text" name="FirstName"><br>
Last Name: <input type="text" name="LastName"><br>
E-Mail: <input type="text" name="Email"><br>
</form>

<p><b>Note:</b> The characters in a password field are masked (shown as asterisks or circles).</p>

</body>
</html>