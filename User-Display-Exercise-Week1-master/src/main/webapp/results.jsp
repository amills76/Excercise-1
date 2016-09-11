<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
<c:if test="${userFound == true}">
    <table width='50%' border='1' align='center'>
        <tr bgcolor='#949494'>
            <th>Users Found</th>
        </tr>
        <tr bgcolor='#949494'>
            <th>User ID</th><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Age</th>
        </tr>
<c:forEach var="person" items="${users}">
        <tr>
            <td>${person.userid}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.dateOfBirth}</td>
            <td>${person.calculateAge()}</td>
        </tr>
</c:forEach>
    </table>
</c:if>
    <c:if test="${userFound == false}">
        <br><p><b><i>
        No Users Found for that search criteria
    </i></b></p>
    </c:if>
    <a href = "index.jsp">Return to User Search</a>
</div>

</body>
</html>
