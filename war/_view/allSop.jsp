<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
<form action="${pageContext.servletContext.contextPath}/allSop" method="post">



<c:forEach items="${sops}" var="sop">
SOP ID Number: ${sop.sopIdNumber} <br>
SOP Title: ${sop.sopName}<br>
SOP Purpose: ${sop.sopPurpose}<br>				
SOP Priority (1-10): ${sop.priority}<br>
SOP Revision Number: ${sop.revision}
</c:forEach>

<form action="/action_page.php">
  Select Files Associated with SOP: <input type="file" name="files" multiple>
  <input type="submit">
    <td><input type = "Submit" name = "index" value = "Index" /> </td>
</form>

</form>


</body>
</html>