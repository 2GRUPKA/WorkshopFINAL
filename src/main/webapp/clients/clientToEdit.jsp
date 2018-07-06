<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/5/18
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<h3> Form to edit clients</h3>

<form action='' method='post' />
<div><label>ID: <br><input type="number" name="id" min="0" required/> </label></div>
<div><label>Name: <br><input type='text' name='name' required /> </label></div>
<div><label>Last Name: <br><input type='text' name='lastName' required /> </label></div>
<div><label>Birth Date: <br><input type='date' name='birthDate' required /> </label></div>
    <br> <input type="submit" name="Submit"/>
</form>
</body>
<%@ include file="/fragments/footer.jsp"  %>

</html>
