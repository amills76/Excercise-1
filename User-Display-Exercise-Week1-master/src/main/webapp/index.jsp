<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<form method="GET" action="searchUser">
    Last Name to Search:<br>
    <input type="text" name="searchTerm"><br>
    <input type="radio" name="searchType" value="searchLastName">
    Search by Last Name<br>
    <input type="radio" name="searchType" value="allUsers">
    Return All Users<br>
    <input type="submit" value="Submit"><br>
</form>
</body>
</html>
