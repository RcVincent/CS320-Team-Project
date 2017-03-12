<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/User" method="post">
Username: <input type="text" name="user"><br>
    <br>
    Passwords did not match. Re-enter Passwords <br>
Password: <input type="password" name="password">
<br>Re-Enter <br>
Password: <input type="password" name="password2">
</form>

<p><b>Note:</b> The characters in a password field are masked (shown as asterisks or circles).</p>

</body>
</html>