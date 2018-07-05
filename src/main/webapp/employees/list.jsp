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

<div>
    <ul>

        <c:forEach var="current_order" items="${Employees.loadAll().toString}">
            <li>
                <h3> ${current_order.getRepairDescription()}</h3>

            </li>
        </c:forEach>
    </ul>

</div>
</body>
</html>
