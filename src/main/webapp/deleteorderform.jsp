<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 05.07.18
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CAR REPAIR</title>
</head>
<body>

<%@ include file="/fragments/header.jsp"  %>


<div>
    <ul>

        <c:forEach var="current_order" items="${listao}">
            <li>

                <h3>id: ${current_order.getId()}, repair description: ${current_order.getRepairDescription()}</h3>

            </li>
        </c:forEach>
    </ul>

</div>
<div>
    <form action="/deleteOrder" method="post">
      id order to delete <div><input type='number' name='idtodelete' min=0 /></div>
        <button>Delete</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
