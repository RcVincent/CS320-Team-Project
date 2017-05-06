<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Revise SOP</title>
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
		.error {
			color: red;
		}
          h1{
          font-size: 40px;
          }
          h3{
          font-size: 15px;
          }
        </style>
      </head>
<body>
<h1 style="text-align: center;"><span style="text-decoration: underline;">Revise SOP</span></h1>
<form action="${pageContext.servletContext.contextPath}/reviseSOP" method="post">
<h3>SOP Title: <input type="text" name="sopName"><br></h3>
<h3>SOP Purpose: <textarea rows="4" cols="50" name="sop_purpose" >
Enter SOP Purpose here...</textarea><br></h3>
<h3>Old Priority (1-10): <input type="text" name="sop_priority"><br></h3>
<h3>Priority (1-10): <input type="text" name="sop_newPriority"><br></h3>
<h3>Old Revision Number : <input type="text" name="sop_Version"><br></h3>
<h3>New Revision Number : <input type="text" name="sop_newVersion"><br></h3>

<td><input type = "Submit" name = "submit" value = "Submit" /> </td>
  <td><input type = "Submit" name = "index" value = "Index" /> </td>
</form>

</form>


</body>
</html>