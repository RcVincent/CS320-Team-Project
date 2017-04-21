<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/changePassword" method="post">
Username: <input type="text" name="user"><br>
Old Password: <input type="text" name="oldPassword">   <br>
New Password: <input type="text" name="password">
<br>Re-Enter <br>
New Password: <input type="text" name="password2">
				<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
				<td><input type = "Submit" name = "index" value = "Index" /> </td>
				<input type="hidden" name="sessionid" value="sessionid.getSessionid">
</form>

<p><b>Note:</b> The characters in a password field are masked (shown as asterisks or circles).</p>

</body>
</html>