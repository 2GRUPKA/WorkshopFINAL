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
    Clients Last name:<input type="text" name="lastName" />
    Clients Date of Birth:<input type="text" name="birthDate" />
    <%--<br><button type="button">Edit</button>--%>
    <%--<button type="button">Delete</button>--%>
    <%--<button type="button">Show All</button>--%>
    <br> <input type="submit" name="Submit"/>
</form>


</body>
</html>
