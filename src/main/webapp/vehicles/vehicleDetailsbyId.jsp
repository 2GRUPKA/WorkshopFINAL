<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 06.07.18
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<h3>Enter id of vehicle, to see all details.</h3>
<div><form method="get" action="/VehicleDetailsById">
    <input type="text" name="id" placeholder="Vehicles id">
    <input type="submit" value="See details">
</form>

</div>
<h3>Details of choosen vehicle:</h3>
<h6>Car: ${veh.getBrand()} ${veh.getModel()},
    registration: ${veh.getRegistrationNumber()},
    production year: ${veh.getProductionYear()},
    next reapair date: ${veh.getNextRepairDate()} </h6>
<h3>Repairs:</h3>
<div>
    <ul>
        <c:forEach var="atr" items="${repairs}">
            <li>
                <h6>id: ${atr.getId()},
                    problem description: ${atr.getProblemDescription()},
                    acceptance date: ${atr.getAcceptanceDate()},
                    repair started: ${atr.getStartRepair()},
                    after repair descreption: ${atr.getRepairDescription()},
                    status: ${atr.getStatus()},
                    repair cost: ${atr.getRepairCost()},
                    cost of parts: ${atr.getPartCost()}
                </h6>

            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
