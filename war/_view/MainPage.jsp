<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/MainPage" method="post">
<div>
Employee Number: ${User.UserID}<br>
First Name: ${User.firstName}<br>
Last Name: ${User.lastName}<br>
E-Mail: ${User.emailAddress}<br>
</div>

</form>
<p>
</p>
</body>
</html>
