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
<%@ include file="/fragments/header.jsp"  %>

<form method='post' action=''/>
<div><label>Name: <br><input type='text' name='name' required /> </label></div>
<div><label>Surname: <br><input type='text' name='lastName' required /> </label></div>
<div><label>Birth Date: <br><input type='date' name='birthDate'  /> </label></div>
<div><input type='submit' value='submit'/> </div>




<%@ include file="/fragments/footer.jsp"  %>


</form>


</body>
</html>