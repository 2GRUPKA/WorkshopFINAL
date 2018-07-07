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
    <title>Vehicle Panel</title>
</head>
<body>
<%--<%@ include file="/fragments/header.jsp"  %>--%>

<p>Menage vehicles:</p>
<a href="/VehicleAdd"><button>Add a vehicle</button>    </a>
<a href="/VehicleEdit"><button>Edit a vehicle</button>  </a>
<a href="/VehicleDelete"> <button>Delete a vehicle</button></a>
<a href="/VehiclesList"> <button>Show all vehicles</button></a>
<a href="/VehicleDetailsById"> <button>Vehicle details</button></a>
<%--<%@ include file="/fragments/footer.jsp"  %>--%>

</body>
</html>
