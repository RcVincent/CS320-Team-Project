<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

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