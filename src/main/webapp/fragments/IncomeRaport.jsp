<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 07.07.18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
<h2>Count Wrokshop income:</h2>
<form method="post" action="">
    <div>Since: <br><input type="date" name="startDate"  required></div>
    <div>Till: <br><input type="date" name="EndDate"  required></div>
    <div><input type="submit" value="Count income"></div>
</form>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
