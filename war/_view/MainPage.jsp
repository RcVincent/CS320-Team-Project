<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/MainPage" method="post">
<div>
<c:forEach items="${user}" var="user">
Employee Number: ${user.UserID}<br>
First Name: ${user.firstName}<br>
Last Name: ${user.lastName}<br>
E-Mail: ${user.emailAddress}<br>
</c:forEach>
</div>
<div>
/--This is where we need to list History --/
<div>
		<input type="hidden" name="userName" value="user.getUsername">			
		<input type="hidden" name="sessionid" value="sessionid.getSessionid">
</form>


</body>
</html>
