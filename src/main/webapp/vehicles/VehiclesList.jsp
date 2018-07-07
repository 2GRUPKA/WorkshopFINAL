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
</div><h3>Vehicles list:</h3>
<div>
    <ul>
        <c:forEach var="vehicles" items="${allVehicles}">
            <li>
                <h3><i>Id:</i> ${vehicles.getId} <i>Car:</i> ${vehicles.getBrand} ${vehicles.getModel} <i>Registration number:</i>
                        ${vehicles.getRegistrationNumber} <i>Car owner's id:</i> ${vehicles.getClient_id}</h3>

            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
