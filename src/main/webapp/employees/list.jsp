<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 05.07.18
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<div>
    <ul>
        <h3>List employees:</h3>
        <c:forEach var="curr_Employee" items="${listEmp}">
            <li>
                <h3> <i>id=</i> ${curr_Employee.getId()}  <i>fullname=</i> ${curr_Employee.getName()} ${curr_Employee.getLastName()}</h3>

            </li>
        </c:forEach>
    </ul>
</div>


</body>
</html>
