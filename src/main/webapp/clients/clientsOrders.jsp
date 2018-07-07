<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 1:57 PM
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

        <c:forEach var="vehicle" items="${list}">
            <li>
                <h6>Vehicles Id: ${vehicle.getId()},
                    brand: ${vehicle.getBrand()},
                    model: ${vehicle.getModel()},
                    productionYear: ${vehicle.getProductionYear()},
                    registrationNumber: ${vehicle.getRegistrationNumber()},
                    nextRepairDate: ${vehicle.getNextRepairDate()},
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
