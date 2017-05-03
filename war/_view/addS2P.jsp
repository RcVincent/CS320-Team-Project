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

<form action="${pageContext.servletContext.contextPath}/addS2P" method="post">
SOP Name: <input type="text" name="sop"><br>
Position Name: <input type="text" name="position">
<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
<td><input type = "Submit" name = "index" value = "Index" /> </td>
<input type="hidden" name="sessionid" value="sessionid.getSessionid">
</form>


</body>
</html>