<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/User" method="post">
The number you are thinking of is ${game.guess}
<div>
Employee Number: ${MileStone1_User.UserID}<br>
First Name: ${MileStone1_User.firstName}<br>
Last Name: ${MileStone1_User.lastName}<br>
E-Mail: ${MileStone1_User.emailAddress}<br>
</div>
<div>
/--This is where we need to list History --/
<div>

</form>


</body>
</html>
