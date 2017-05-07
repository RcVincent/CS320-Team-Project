<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
      <title>All Users</title>
		<style type = "text/css">
          body{
           font-family: Verdan;
          
        background: -moz-linear-gradient(0deg, rgba(0,255,255,1) 0%, rgba(255,255,255,1) 37%, rgba(0,128,128,1) 100%); /* ff3.6+ */
		background: -webkit-gradient(linear, left top, right top, color-stop(0%, rgba(0,255,255,1)), color-stop(37%, rgba(255,255,255,1)), color-stop(100%, rgba(0,128,128,1))); /* safari4+,chrome */
		background: -webkit-linear-gradient(0deg, rgba(0,255,255,1) 0%, rgba(255,255,255,1) 37%, rgba(0,128,128,1) 100%); /* safari5.1+,chrome10+ */
		background: -o-linear-gradient(0deg, rgba(0,255,255,1) 0%, rgba(255,255,255,1) 37%, rgba(0,128,128,1) 100%); /* opera 11.10+ */
		background: -ms-linear-gradient(0deg, rgba(0,255,255,1) 0%, rgba(255,255,255,1) 37%, rgba(0,128,128,1) 100%); /* ie10+ */
		background: linear-gradient(90deg, rgba(0,255,255,1) 0%, rgba(255,255,255,1) 37%, rgba(0,128,128,1) 100%); /* w3c */
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00ffff', endColorstr='#008080',GradientType=1 ); /* ie6-9 */

          h1{
          font-size: 40px;
          }
          h3{
          font-size: 15px;
          }
        </style>
      </head>

<body>

		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
<form action="${pageContext.servletContext.contextPath}/allUsers" method="post">



<c:forEach items="${users}" var="user">
	<h3> Name:  ${user.lastName},  ${user.firstName}</h3>
	<h3> Employee ID: ${user.userID}</h3>
	<h3> Active Username: ${user.username}</h3>
	<h3> Email:  ${user.emailAddress}</h3>				
<br>
</c:forEach>


  <input type="submit">
    <td><input type = "Submit" name = "index" value = "Index" /> </td>


</form>


</body>
</html>