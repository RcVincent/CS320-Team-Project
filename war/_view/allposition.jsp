<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
<form action="${pageContext.servletContext.contextPath}/allposition" method="post">



<c:forEach items="${positions}" var="position">
Position ID Number: ${position.positionIdS} <br>
Position Name: ${position.positionName}<br>
Position Duty: ${position.positionDuty}<br>				

</c:forEach>


  <input type="submit">
    <td><input type = "Submit" name = "index" value = "Index" /> </td>


</form>


</body>
</html>