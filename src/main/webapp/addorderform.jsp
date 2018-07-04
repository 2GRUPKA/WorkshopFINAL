<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 04.07.18
  Time: 16:51
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
    <form action='' metod="post">
        <input type='date' name='acceptanceDate' required placeholder="date" />
        <input type='date' name='planningStartDate' required placeholder="planningStartDate" />
        <input type='date' name='startRepair' required placeholder="startRepair" />
        <input type='text' name='employee_id' required placeholder="employee_id" />
        <input type='text' name='problemDescription' required placeholder="problemDescription" />
        <input type='text' name='repairDescription' required placeholder="repairDescription" />

        <input type='text' name='status' required placeholder="status" />

        <input type='text' name='vehicle_id' required placeholder="vehicle_id" />

        <input type='text' name='repairCost' required placeholder="repairCost" />

        <input type='text' name='partCost' required placeholder="partCost" />

        <input type='text' name='repairHours' required placeholder="repairHours" />
        <button>SAVE TO DB</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
