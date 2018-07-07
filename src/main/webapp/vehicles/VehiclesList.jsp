<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 06.07.18
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<h3>Vehicles list:</h3>
<div>
    <ul>
        <c:forEach var="vehicle" items="${allVehicles}">
            <li>
                <h5>Id: ${vehicle.id},
                    Car: ${vehicle.brand} ${vehicle.model},
                    Registration number: ${vehicle.registrationNumber},
                    Car owner's id: ${vehicle.client_id}
                    <a href="?delete=${vehicle.id}">Delete this vehicle.  </a>
                    <a href="VehicleDetailsById?showDetails=${vehicle.id}">Show Details.  </a>
                    <a href="VehicleEdit?id=${vehicle.id}">Edit.  </a>
                </h5>

            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
