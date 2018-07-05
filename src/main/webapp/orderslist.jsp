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
             ${current_order.getRepairDescription()}

        </li>
    </c:forEach>
</ul>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
