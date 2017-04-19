<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<form action="${pageContext.servletContext.contextPath}/MainPage" method="post">
<div>
Employee Number: ${User.UserID}<br>
First Name: ${User.firstName}<br>
Last Name: ${User.lastName}<br>
E-Mail: ${User.emailAddress}<br>
</div>

</form>
<table>
<tr>                
   <td>        
   @using (Html.BeginCollectionItem("HoldThisL"))
   {             
            @Html.TextBoxFor(m => m.Description)
            @Html.ValidationMessageFor(m => m.Description)                              
        @:</td>
        @:<td>
            @Html.TextBoxFor(m => m.Quantity)        
            @Html.ValidationMessageFor(m => m.Quantity)
        @:</td>
        @:<td>
            @Html.TextBoxFor(m => m.Amount)          
            @Html.ValidationMessageFor(m => m.Amount)       
   }       
   </td>
</tr>
</table>>
</body>
</html>
