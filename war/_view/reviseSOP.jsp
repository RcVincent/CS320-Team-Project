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

<form action="${pageContext.servletContext.contextPath}/CreateAccount" method="post">
SOP ID: <input type="text" name="sop_Id"><br>
SOP Version: <input type="text" name="version"><br>
New SOP Version: <input type="text" name="newVersion"><br>
<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
<td><input type = "Submit" name = "index" value = "Index" /> </td>
<input type="hidden" name="sessionid" value="sessionid.getSessionid">
</form>


</body>
</html>