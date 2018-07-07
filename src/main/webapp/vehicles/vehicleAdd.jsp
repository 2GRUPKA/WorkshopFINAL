<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 05.07.18
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
    <h2>Add new vehicle.</h2>
    <form method="post" action="">
        <div><input type="text" name="brand" placeholder="Vehicle's brand" required></div>
        <div><input type="text" name="model" placeholder="Vehicle's model" required></div>
        <div><input type="date" name="productionYear" placeholder="Vehicle's year of production" required></div>
        <div><input type="text" name="registrationNumber" placeholder="Vehicle's registration number" required></div>
        <div><input type="date" name="nextRepairDate" placeholder="Vehicle's next visit date"></div>
        <div><input type="text" name="client_id" placeholder="Owner's id"></div>
        <div><input type="submit" value="Add this vehicle"></div>
    </form>
<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
