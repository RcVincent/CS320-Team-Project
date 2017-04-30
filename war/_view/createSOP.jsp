<!DOCTYPE html>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

 
<html>
	<head>
      <title> Create SOP </title>
		<style type = "text/css">
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
        </style>
      </head>
<body>
<<<<<<< HEAD
<h1 style="text-align: center;"><span style="text-decoration: underline;">Create SOP</span></h1>
  
<h3>SOP ID Number: <input name="sopIDNumber" type="text" />  </h3>
<h3>SOP Title: <input name="sopName" type="text" /></h3>
  
<h3>Author of SOP: <input name="sopAuthor" type="text" /></h3>
  
<h3>Author ID Number: <input name="authorIDnumber" type="text" /></h3>
  
<h3>Priority (1-10): <input name="priority" type="text" /><br /></h3>
  <h3>Revision Number : 1</h3>
  
<h3>Select Files Associated with SOP: <input multiple="multiple" name="files" type="file" /> </h3>
 <h3> <input type="submit" /></h3>
  </body>
=======

<form action="${pageContext.servletContext.contextPath}/createSOP" method="post">
SOP Title: <input type="text" name="sopName"><br>
SOP Purpose: <textarea rows="4" cols="50" name="sop_purpose" >
Enter SOP Purpose here...</textarea><br>
Priority (1-10): <input type="text" name="sop_priority"><br>
Revision Number : <input type="text" name="sop_revision"><br>

<form action="/action_page.php">
  Select Files Associated with SOP: <input type="file" name="files" multiple>
  <input type="submit">
  <td><input type = "Submit" name = "index" value = "Index" /> </td>
</form>

</form>


</body>
</html>
>>>>>>> refs/remotes/Dave-Remote/master
