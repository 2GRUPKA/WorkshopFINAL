<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CAR REPAIR</title>
</head>
<body>

<%@ include file="/fragments/header.jsp"  %>


<div>

                <h6>id: ${ordersDao.id},
                    acceptance: ${ordersDao.acceptanceDate},
                    planning: ${ordersDao.planningStartDate},
                    start: ${ordersDao.startRepair},
                    employee: ${ordersDao.employee_id},
                    problem: ${ordersDao.problemDescription},
                    repair description: ${ordersDao.repairDescription},
                    status: ${ordersDao.status},
                    vehicle: ${ordersDao.vehicle_id},
                    repair cost: ${ordersDao.repairCost},
                    part cost: ${ordersDao.partCost},
                    repair hours: ${ordersDao.repairHours}


</div>
<div>
    <form action="/OrderDetails" method="post">
        order's id<div><input type='number' name='idtoshow' min=0 /></div>
        <button>Show</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>