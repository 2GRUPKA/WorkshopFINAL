<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 04.07.18
  Time: 16:51
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

    <c:forEach var="current_order" items="${listao}">
        <li>
            <h6>id: ${current_order.getId()},
                acceptance: ${current_order.getAcceptanceDate()},
                employee: ${current_order.getEmployee_id()},
                problem: ${current_order.getProblemDescription()},
                repair description: ${current_order.getRepairDescription()},
                status: ${current_order.getStatus()},
                vehicle: ${current_order.getVehicle_id()},
                <%--<a href="/detailsordershow.jsp?id=${current_order.getId()}">DETAILS</a>--%>
                <form action="/OrderDetails" method="post">
                    <input type="hidden" name="idtoshow" value="${current_order.getId()}" />
                    <%--<input  type='submit' name = 'idtoshow'    value = '${current_order.getId()}'>--%>
                    <button>details</button>
                </form>

        </li>
    </c:forEach>
</ul>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
