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
<div>
    <ul>
        <h3>Vehicles list:</h3>
        <c:forEach var="vehicle" items="${allVehicls}">
            <li>
                <h6> <i>Id:</i> ${vehicle.getId()}  <br><i>Car:</i> ${vehicle.getBrand()}, ${vehicle.getModel()}</h6>

            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
