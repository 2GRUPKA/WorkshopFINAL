<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 06.07.18
  Time: 10:47
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
        <h3>List orders with employee id: ${param.id}</h3>
        <c:forEach var="curr_order" items="${listOrders}">
            <li>
                <h3> <i>Vehicle id=</i> ${curr_order.vehicle_id()}  <i>Status=</i> ${curr_order.id} ${curr_order.status}</h3>

            </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
