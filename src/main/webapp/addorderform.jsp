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
    <form action="" method="post">
        <div><input type='date' name='acceptanceDate' required/></div>

        <div> <input type='date' name='planningStartDate' required/></div>

<div> <input type='date' name='startRepair' required/></div>

<div> <input type='text' name='employee_id' required placeholder="employee_id" /></div>

<div><input type='text' name='problemDescription' required placeholder="problemDescription" /></div>

<div><input type='text' name='repairDescription' required placeholder="repairDescription" /></div>

<div> <input type='text' name='status' required placeholder="status" /></div>

<div> <input type='text' name='vehicle_id' required placeholder="vehicle_id" /></div>

<div> <input type='text' name='repairCost' required placeholder="repairCost" /></div>

<div><input type='text' name='partCost' required placeholder="partCost" /></div>

<div><input type='text' name='repairHours' required placeholder="repairHours" /></div>
        <button>SAVE TO DB</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
