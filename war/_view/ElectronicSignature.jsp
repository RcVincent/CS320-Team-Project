<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Knowing the Importance of your electronic Signature </title>
	
	<style type = "text/css">
          body{
          font-family: Verdan;
          
          background-color: lightblue
          }
          
          .error {
			color: red;
		  }
		
          h1{
          font-size: 40px;
          }
          
          p{
          font-size: 15px;
          }
    </style>
</head>

<body>

	<form action="${pageContext.servletContext.contextPath}/ElectronicSignature" method="post">

	<h1> 		Concerning Training </h1>
	<br>
	<p> This section is to tell you about the importance of signing your name electronically on a document we provide you. Your
		electronic signature is as legally binding as one made with ink. Failure to do comply this understanding is punishable by 
		banishment to the shadow realm. We have a very complex set of algorithms running the surveillance feeds: trust us we will find you.
		
		Knowing this information you now hopefully understand the gravity of clicking the "I understand the material" button and pressing the "Electronically sign"
		button. You are legally bound to us now, and should we prove that you lied about completing your training you will be subject to being tared and feathered. 
		Or probably just reprimanded by your manager. If he/she recommends the rack, who are we to judge?  
		
		I do believe this ends the very first step in your training. Now off with you, or we'll toss you over the north wall. 
	</p>
	
	<td> </td>
	<td> <input type = "Submit" name = "submit" value = "Submit" /> </td>
			
	
	</form>
</body>
</html>