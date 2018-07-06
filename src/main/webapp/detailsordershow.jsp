<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CAR REPAIR</title>
</head>
<body>

<%@ include file="/fragments/header.jsp"  %>


<div>

                <h6>id: ${param.ordersDao.getId()},
                    acceptance: ${ordersDao.getAcceptanceDate()},
                    planning: ${ordersDao.getPlanningStartDate()},
                    start: ${ordersDao.getStartRepair()},
                    employee: ${ordersDao.getEmployee_id()},
                    problem: ${ordersDao.getProblemDescription()},
                    repair description: ${ordersDao.getRepairDescription()},
                    status: ${ordersDao.getStatus()},
                    vehicle: ${ordersDao.getVehicle_id()},
                    repair cost: ${ordersDao.getRepairCost()},
                    part cost: ${ordersDao.getPartCost()},
                    repair hours: ${ordersDao.getRepairHours()}


</div>
<div>
    <form action="/detailsOrder" method="post">
        order's id<div><input type='number' name='idtoshow' min=0 /></div>
        <button>Show</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>