<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/5/18
  Time: 9:01 PM
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
        <h3>List clients:</h3>
        <c:forEach var="clients" items="${listClients}">
            <li>
                <h3> <i>id:</i> ${clients.getId()} Name: ${clients.getName()} ${clients.getLastName()}</h3>

            </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="/fragments/footer.jsp"  %>


</body>
</html>
