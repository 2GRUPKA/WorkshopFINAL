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
<%@ include file="/fragments/header.jsp"  %>
<div>
    <ul>
        <h3>List employees:</h3>
        <c:forEach var="curr_Employee" items="${listEmp}">
            <li>
                <h3> <i>id=</i> ${curr_Employee.getId()}  <i>fullname=</i> ${curr_Employee.getName()} ${curr_Employee.getLastName()}</h3>

            </li>
        </c:forEach>
    </ul>
</div>

<form method='post' action=''>
    <div> <label> Type id order to delete </label></div>
    <input type='number' name='id' min=0 />
    </label> <input type='submit' value='submit'/>
<%@ include file="/fragments/footer.jsp"  %>

</form>
</body>
</html>
