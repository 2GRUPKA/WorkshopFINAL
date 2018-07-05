<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/4/18
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/AddClient">
    Clients Name:<input type="text" name="name" />
    <br>Clients Last name:<input type="text" name="lastName" />
    <br>Clients Date of Birth:<input type="date" name="birthDate" />
    <br> <input type="submit" name="Submit"/>

   <br><input type="button" value="Main Page " onclick="window.location.href='/index.jsp'" />


</form>


</body>
</html>
