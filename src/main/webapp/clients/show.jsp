<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: karussia
  Date: 7/7/18
  Time: 3:15 AM
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
    <ul>

                <h6>Clients Id: ${clients.id},
                    Clients Name: ${clients.name},
                    Clients Last Name: ${clients.lastName},

                </h6>

    </ul>
</div>
<div>
    <form action="/SearchByLastName" method="post">
        Clients's last name:<div><input type='text' name='lastName'  /></div>
        <button>Show</button>

    </form>

</div>


<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
