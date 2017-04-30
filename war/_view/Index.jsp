<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<title> Index </title>
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
	
	#index {
    	margin: 50px auto;
		border: 1px solid darkblue;
		width: 400px;
		padding: 10px;
	}

	</style>
	
	</head>
	
	<body>	
	<c:if test="${! empty errorMessage }">
						<div class = "error"> ${errorMessage}</div>
					</c:if>		
	<form action = "${pageContext.servletContext.contextPath}/Index" method = "post">
		<div id = "PageName"> Welcome to the Compliance Training Monitor</div>
		<div id = "index">
		<table>
			<tr>
			<input name="createAccount" type="submit" value="Create Account" />
			</tr>
			<tr>
			<input name="changePW" type="submit" value="Change Password" />
			</tr>
			<tr>
			<input name="account" type="submit" value="Account" />
			</tr>
			<tr>
			<input name="createSOP" type="submit" value="Create SOP" />
			</tr>
			<tr>
			<input name="MainPage" type="submit" value="Main Page" />
			</tr>
			<tr>
			<input name="reviseSOP" type="submit" value="Revise SOP" />
			</tr>
			<tr>
			<input name="sop" type="submit" value="SOP" />
			</tr>
			<tr>
			<input name="trainingHistory" type="submit" value="Training History" />
			</tr>
			<input name="createPosition" type="submit" value="Create Position" />
			</tr>
						</tr>
			<input name="addP2U" type="submit" value="Add Position to User" />
			</tr>
			<tr>
				<td><input type = "Submit" name = "Login" value = "Login" /> </td>
				<input type="hidden" name="sessionid" value="sessionid.getSessionid">
				</form>
			</tr>
	
				
		</table>
		</div>
	</form>
	</body>
</html>		
