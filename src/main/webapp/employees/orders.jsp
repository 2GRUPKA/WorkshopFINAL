<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 05.07.18
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<div> Type employee id to show orders
    <form method="get", action="/employeeOrders"/>
    <input type="number" name="id" required/>
    <input type="submit" value="submit"/>
    </form>
 </div>

<div>
    <ul>

        <c:forEach var="current_order" items="${listEO}">
            <li>
                <h6>id: ${current_order.getId()},
                    acceptance: ${current_order.getAcceptanceDate()},
                    planning: ${current_order.getPlanningStartDate()},
                    start: ${current_order.getStartRepair()},
                    employee: ${current_order.getEmployee_id()},
                    problem: ${current_order.getProblemDescription()},
                    repair description: ${current_order.getRepairDescription()},
                    status: ${current_order.getStatus()},
                    vehicle: ${current_order.getVehicle_id()},
                    repair cost: ${current_order.getRepairCost()},
                    part cost: ${current_order.getPartCost()},
                    repair hours: ${current_order.getRepairHours()}
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
