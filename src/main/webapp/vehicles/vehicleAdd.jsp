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
        <div>Vehicle's brand: <br><input type="text" name="brand"  required></div>
        <div>Vehicle's model: <br><input type="text" name="model"  required></div>
        <div>Vehicle's year of production: <br><input type="date" name="productionYear"  required></div>
        <div>Vehicle's registration number: <br><input type="text" name="registrationNumber"  required></div>
        <div>Vehicle's next visit date: <br><input type="date" name="nextRepairDate" ></div>
        <div>Owner's id: <br><input type="text" name="client_id" required></div>
        <div><input type="submit" value="Add this vehicle"></div>
    </form>
<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
