<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<title> Index </title>
	<style type = "text/css">
	.error {
			background-color: red;
			font-color:black;
		}
		
	td.label{
		text-align: right;
	}
	
	button{
		margin-top: 2px;
	}
	
	body{
           font-family: Verdan;
          
          background-color: lightblue
          }
          h1{
          font-size: 40px;
          }
          h3{
          font-size: 15px;
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
		
			<!--		<form action = "${pageContext.servletContext.contextPath}/Index" method = "post"></form>
					<c:if test="${! empty errorMessage }">
						<div class = "error"> ${errorMessage}</div>
					</c:if>
					
			
			
			
			
			
			
			
			
			</tr>
			<tr>
				-->	
			<input name="createAccount" type="submit" value="Create Account" /><br>
			</tr>
			<tr>
			<input name="changePW" type="submit" value="Change Password" /><br>
			</tr>
			<tr>
			<input name="account" type="submit" value="Account" /><br>
			</tr>
			<tr>
			<input name="createSOP" type="submit" value="Create SOP" /><br>
			</tr>
			<tr>
			<input name="MainPage" type="submit" value="Main Page" /><br>
			</tr>
			<tr>
			<input name="reviseSOP" type="submit" value="Revise SOP" /><br>
			</tr>
			<tr>
			<input name="sop" type="submit" value="Find SOP by name" /><br>
			</tr>
			<tr>
			<input name="allsop" type="submit" value="Find all SOPs" /><br>
			</tr>
			<tr>
			<input name="trainingHistory" type="submit" value="Training History" /><br>
			</tr>
			<input name="createPosition" type="submit" value="Create Position" /><br>
			</tr>
			<tr>
			<input name="position" type="submit" value="Find Position By Name" /><br>
			</tr>
			<tr>
			<input name="allposition" type="submit" value="Find All Positions" /><br>
			</tr>
			<tr>
			<input name="addP2U" type="submit" value="Add Position to User" /><br>
			</tr>
			<tr>
			<input name="addS2P" type="submit" value="Add SOP to Position" /><br>
			</tr>
			<tr>
				<td><input type = "Submit" name = "Login" value = "Login" /><br> </td>
				<input type="hidden" name="sessionid" value="sessionid.getSessionid">
				</form>
			</tr>
	
				
		</table>
		</div>
	</form>
	</body>
</html>		
