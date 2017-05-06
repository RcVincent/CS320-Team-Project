<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<title>User Account Data</title>
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

<form action="${pageContext.servletContext.contextPath}/account" method="post">
<div>
User Name: <input type="text" name="username">   <br>

	<h3> Name:  ${user.lastName},  ${user.firstName}</h3>
	<h3> Employee ID: ${user.userID}</h3>
	<h3> Active Username: ${user.username}</h3>
	<h3> Email:  ${user.emailAddress}</h3>

</div>
<div>
/--SOPs need for this Employee --/<br>
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

<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
<td><input type = "Submit" name = "Index" value = "Index" /> </td>
</form>


</body>
</html>