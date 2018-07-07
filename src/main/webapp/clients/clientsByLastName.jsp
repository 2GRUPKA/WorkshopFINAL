<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 2:54 AM
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

        <c:forEach var="client" items="${list}">
            <li>
                <h6>id: ${client.getId()},
                     name: ${client.name()},
                </h6>
            </li>
        </c:forEach>
    </ul>

</div>
<div>
    <form action="/SearchByLastName" method="post">
        Clients's last name:<div><input type='text' name='lastNameToShow'  /></div>
        <button>Show</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

    </body>
    </html>
