<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 05.07.18
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<div> Type employee id to show orders
    <form method="post", action=""/>
    <input type="number" name="id" required/>
    </form>
 </div>
<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
