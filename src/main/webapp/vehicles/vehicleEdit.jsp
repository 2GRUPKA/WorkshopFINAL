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
        <div><input type="text" name="id" required value="${vehicle.id}">Vehicle's id</div>
        <div><input type="text" name="brand" value="${vehicle.brand}">Vehicle's brand</div>
        <div><input type="text" name="model" value="${vehicle.model}">Vehicle's model</div>
        <div><input type="date" name="productionYear" value="${vehicle.productionYear}" >Vehicle's year of production</div>
        <div><input type="text" name="registrationNumber"  value="${vehicle.registrationNumber}">Vehicle's registration number</div>
        <div><input type="date" name="nextRepairDate" value="${vehicle.nextRepairDate}">Vehicle's next visit date</div>
        <div><input type="text" name="client_id" value="${vehicle.client_id}">Car owner's id</div>


        <div><input type="submit" value="Confirm changes"></div>
    </form>
    <%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
