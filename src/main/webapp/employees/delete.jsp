<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 04.07.18
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <ul>

        <c:forEach var="current_order" items="${}">
            <li>
                <h3> ${current_order.getRepairDescription()}</h3>

            </li>
        </c:forEach>
    </ul>

</div>
<form method='post' action=''>
    <div> <label> Type id order to delete </label></div>
    <input type='number' name='id' min=0 />
    </label> <input type='submit' value='submit'/>
</form>
</body>
</html>
