<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/MainPage" method="post">
<div>


First Name: ${user.firstName}<br>
Last Name: ${user.lastName}<br>
E-Mail: ${user.emailAddress}<br>

</div>
<div>
/--SOPs needed for this Employee --/<br>
<br>
<c:forEach items="${sops}" var="sop">
SOP ID Number: ${sop.sopIdNumber} <br>
SOP Title: ${sop.sopName}<br>
SOP Purpose: ${sop.sopPurpose}<br>				
SOP Priority (1-10): ${sop.priority}<br>
SOP Revision Number: ${sop.revision}<br>
<br>
</c:forEach>
<div>
<tr>
			<input name="changePW" type="submit" value="Change Password" />
			</tr>

</form>


</body>
</html>
