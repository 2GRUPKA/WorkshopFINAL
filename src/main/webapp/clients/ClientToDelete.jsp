<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/4/18
  Time: 4:03 PM
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
        <h3>Form to delete a client</h3>

        <c:forEach var="clients" items="${listClients}">
            <li>
                <h3> <i>id:</i> ${clients.getId()} Name: ${clients.getName()} ${clients.getLastName()}</h3>

            </li>
        </c:forEach>
    </ul>
</div>


<form method='post' action="/DeleteClient">
    <div> <label> Type clients id to delete </label></div>
    <input type='number' name='id' min=0 />
    </label> <input type='submit' value='submit'/>
    <%@ include file="/fragments/footer.jsp"  %>

</form>

</body>
</html>