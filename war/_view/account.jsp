<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/account" method="post">
<div>
User Name: <input type="text" name="username">   <br>

First Name: ${user.firstName}<br>
Last Name: ${user.lastName}<br>
E-Mail: ${user.emailAddress}<br>

</div>
<div>
/--This is where we need to list History --/
<div>

<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
<td><input type = "Submit" name = "Index" value = "Index" /> </td>
</form>


</body>
</html>