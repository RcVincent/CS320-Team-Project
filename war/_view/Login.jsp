<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<title> Login </title>
	<style type = "text/css">
	.error {
			color: red;
		}
		
	td.label{
		text-align: right;
	}
	
	button{
		margin-top: 2px;
	}
	
	#PageName {
		color: white;
		font-size: 250%;
		text-align: center;
		background-color: darkblue;
		font-variant: small-caps;
	}
	
	#logon {
    	margin: 50px auto;
		border: 1px solid darkblue;
		width: 400px;
		padding: 10px;
	}

	</style>
	
	</head>
	
	<body>			
	
		<div id = "PageName"> Welcome to the Compliance Training Monitor</div>
		<div id = "logon">
		<table>
			<tr>
				<form action = "${pageContext.servletContext.contextPath}/Login" method = "post"></form>
					<c:if test="${! empty errorMessage }">
						<div class = "error"> ${errorMessage}</div>
					</c:if>
					
					<td class = "label"> Username: </td>
					<td> <input type = "text" name = "username" size = "12" /> </td>
			</tr>
			
			<tr>
					<td class = "label"> Password: </td>
					<td><input type = "password" name = "password" size = "12"/></td>
			</tr>
			
			<tr>
				<td><input type = "Submit" name = "submit" value = "Login" /> </td>
				</form>
			</tr>
	
				
		</table>
		</div>
	
	</body>
</html>		
