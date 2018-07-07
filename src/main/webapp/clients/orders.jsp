<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<div> Type in clients id to show its orders:
    <form method="get", action="/ClientsOrders"/>
    <input type="number" name="id" required/>
    <input type="submit" value="submit"/>
    </form>
</div>

<div>
    <ul>

        <c:forEach var="vehicle" items="${list}">
            <li>
                <h6>Orders Id: ${vehicle.getId()},
                    acceptance: ${vehicle.getAcceptanceDate()},
                    planning: ${vehicle.getPlanningStartDate()},
                    start: ${vehicle.getStartRepair()},
                    employee: ${vehicle.getEmployee_id()},
                    problem: ${vehicle.getProblemDescription()},
                    repair description: ${vehicle.getRepairDescription()},
                    status: ${vehicle.getStatus()},
                    vehicle: ${vehicle.getVehicle_id()},
                    repair cost: ${vehicle.getRepairCost()},
                    part cost: ${vehicle.getPartCost()},
                    repair hours: ${vehicle.getRepairHours()}
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
