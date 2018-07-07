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
        <div><input type="text" name="brand"  required>Vehicle's brand</div>
        <div><input type="text" name="model"  required>Vehicle's model</div>
        <div><input type="date" name="productionYear"  required>Vehicle's year of production</div>
        <div><input type="text" name="registrationNumber"  required>Vehicle's registration number</div>
        <div><input type="date" name="nextRepairDate" >Vehicle's next visit date</div>
        <div><input type="text" name="client_id" required>Owner's id</div>
        <div><input type="submit" value="">Add this vehicle</div>
    </form>
<%@ include file="/fragments/footer.jsp"  %>
</body>
</html>
