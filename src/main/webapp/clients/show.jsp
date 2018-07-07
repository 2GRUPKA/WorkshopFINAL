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

    <h6>id: ${ClientsDao.id},
        acceptance: ${ClientsDao.name},
        planning: ${ClientsDao.lastName},
        start: ${ClientsDao.birthDate},



</div>
<div>
    <form action="/SearchByLastName" method="post">
        Clients's last name<div><input type='text' name='clientToShow' /></div>
        <button>Show</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
