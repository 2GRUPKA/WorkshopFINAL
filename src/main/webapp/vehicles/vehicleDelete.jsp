<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 06.07.18
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<form method='post' action=''>
    <div> <label>Delete vehicle.</label></div>
    <input type='text' name='id' min=1 required/>
    <input type='submit' value='Delete.'/>
</form>
    <%@ include file="/vehicles/VehiclesList.jsp"  %>
    <%@ include file="/fragments/footer.jsp"  %>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
