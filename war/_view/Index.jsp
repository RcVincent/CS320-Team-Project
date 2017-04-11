<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<title> Login </title>
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
	
		<div id = "PageName"> Welcome to the Compliance Training Monitor</div>
		<div id = "index">
		<table>
			<tr>
				<form action = "${pageContext.servletContext.contextPath}/Index" method = "post"></form>
					<c:if test="${! empty errorMessage }">
						<div class = "error"> ${errorMessage}</div>
					</c:if>
					
					
			
			
			
			
			
			
			
			</tr>
			<tr>
			<input name="createAccount" type="submit" value="Create Account" />
			</tr>
			<tr>
			<input name="account" type="submit" value="Account" />
			</tr>
			<tr>
			<input name="createAccount" type="submit" value="Create Account" />
			</tr>
			<tr>
			<input name="createSOP" type="submit" value="Create SOP" />
			</tr>
			<tr>
			<input name="mainPage" type="submit" value="Main Page" />
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
			<tr>
				<td><input type = "Submit" name = "submit" value = "Login" /> </td>
				</form>
			</tr>
	
				
		</table>
		</div>
	
	</body>
</html>		
