<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 06.07.18
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@ include file="/fragments/header.jsp"  %>--%>

<h2>Menage vehicles:</h2>
<a href="/vehicles/vehicleAdd.jsp"><button>Add a vehicle</button>    </a>
<a href="/vehicles/vehicleEdit.jsp"><button>Edit a vehicle</button>  </a>
<a href="/vehicles/vehicleDelete.jsp"> <button>Delete a vehicle</button></a>
<a href="/vehicles/VehiclesList.jsp"> <button>Show all vehicles</button></a>
<a href="/vehicles/vehicleDetailsbyId.jsp"> <button>Vehicle details</button></a>
<%--<%@ include file="/fragments/footer.jsp"  %>--%>

</body>
</html>
