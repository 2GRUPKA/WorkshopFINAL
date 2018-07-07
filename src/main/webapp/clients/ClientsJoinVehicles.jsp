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
<%--<div> Type clients id to see its vehicles:--%>
    <%--<form method="get", action="/employeeOrders"/>--%>
    <%--<input type="number" name="id" required/>--%>
    <%--<input type="submit" value="submit"/>--%>
    <%--</form>--%>
<%--</div>--%>
<div>
    <ul>

        <c:forEach var="vehicle" items="${allVehicles}">
            <li>
                <h6>id: ${vehicle.id},
                    brand: ${vehicle.brand},
                    model: ${vehicle.model},
                    productionYear: ${vehicle.productionYear},
                    registrationNumber: ${vehicle.registrationNumber()},
                    nextRepairDate: ${vehicle.nextRepairDate()},
                </h6>
            </li>
        </c:forEach>
    </ul>
</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
