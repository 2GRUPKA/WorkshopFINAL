<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 06.07.18
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/fragments/header.jsp"  %>
    <h2>Edit your vehicle.</h2>
    <form method="post" action="">
        <div>Vehicle's id: <br><input type="text" name="id" required value="${vehicle.id}"></div>
        <div>Vehicle's brand: <br><input type="text" name="brand" value="${vehicle.brand}"></div>
        <div>Vehicle's model: <br><input type="text" name="model" value="${vehicle.model}"></div>
        <div>Vehicle's year of production: <br><input type="date" name="productionYear" value="${vehicle.productionYear}" ></div>
        <div>Vehicle's registration number: <br><input type="text" name="registrationNumber"  value="${vehicle.registrationNumber}"></div>
        <div>Vehicle's next visit date: <br><input type="date" name="nextRepairDate" value="${vehicle.nextRepairDate}"></div>
        <div>Car owner's id: <br><input type="text" name="client_id" value="${vehicle.client_id}"></div>


        <div><input type="submit" value="Confirm changes"></div>
    </form>
    <%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
