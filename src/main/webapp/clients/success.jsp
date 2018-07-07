<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 2:30 AM
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
    <h3>You have successfully added a new client: ${param.name} ${param.lastName}</h3>


</div>
<%@ include file="/fragments/footer.jsp"  %>


</body>
</html>
