<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/User" method="post">
SOP ID Number: <input type ="text" name="sopIDNumber"><br>
SOP Title: <input type="text" name="sopName"><br>
Author of SOP: <input type="text" name="sopAuthor"><br>
Author ID Number: <input type="text" name="authorIDnumber"><br>
Priority (1-10): <input type="text" name="priority"><br>
Revision Number : 1

<form action="/action_page.php">
  Select Files Associated with SOP: <input type="file" name="files" multiple>
  <input type="submit">
</form>

</form>


</body>
</html>