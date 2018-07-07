<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 12:26 AM
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

        <c:forEach var="orders" items="${list}">
            <li>
                <h6>Orders Id: ${orders.getId()},
                    acceptance: ${orders.getAcceptanceDate()},
                    planning: ${orders.getPlanningStartDate()},
                    start: ${orders.getStartRepair()},
                    employee: ${orders.getEmployee_id()},
                    problem: ${orders.getProblemDescription()},
                    repair description: ${orders.getRepairDescription()},
                    status: ${orders.getStatus()},
                    vehicle: ${orders.getVehicle_id()},
                    repair cost: ${orders.getRepairCost()},
                    part cost: ${orders.getPartCost()},
                    repair hours: ${orders.getRepairHours()}
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
