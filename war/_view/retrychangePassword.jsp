<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<title>Change Password</title>
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
}
          
          h1{
          font-size: 40px;
          }
          h3{
          font-size: 15px;
          }
        </style>
<body>

<form action="${pageContext.servletContext.contextPath}/changePassword" method="post">
<h1>Passwords did not match. Re-enter Passwords <br></h1>
<h3>Old Password: <input type="password" name="oldPassword">   <br></h3>
<h3>New Password: <input type="password" name="password"></h3>
<h3><br>Re-Enter <br></h3>
<h3>New Password: <input type="password" name="password2"></h3>
				<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
				<td><input type = "Submit" name = "Index" value = "Index" /> </td>
				
</form>

<p><b>Note:</b> The characters in a password field are masked (shown as asterisks or circles).</p>

</body>
</html>