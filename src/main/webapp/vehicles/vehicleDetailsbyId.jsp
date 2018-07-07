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

<h3>Details of choosen vehicle:</h3>
<h6>Car: ${veh.brand} ${veh.model},
    registration: ${veh.registrationNumber},
    production year: ${veh.productionYear},
    next reapair date: ${veh.nextRepairDate}
    Car owner's id ${veh.client_id}
</h6>
<h3>Repairs:</h3>
<div>
    <ul>
        <c:forEach var="atr" items="${repairs}">
            <li>
                <h6>id: ${atr.getId()},
                    problem description: ${atr.problemDescription},
                    acceptance date: ${atr.acceptanceDate},
                    repair started: ${atr.startRepair},
                    after repair descreption: ${atr.repairDescription},
                    status: ${atr.status},
                    repair cost: ${atr.repairCost},
                    cost of parts: ${atr.partCost}
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
