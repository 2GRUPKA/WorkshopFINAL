package pl.coderslab.servlets;

import pl.coderslab.dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet(name = "OrdersEdit", urlPatterns = "/editOrder")
public class OrdersEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        String acceptanceDate = request.getParameter("acceptanceDate");
        String planningStartDate = request.getParameter("planningStartDate");
        String startRepair = request.getParameter("startRepair");
        String employee_id = request.getParameter("employee_id");
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        String status = request.getParameter("status");
        String vehicle_id = request.getParameter("vehicle_id");
        String repairCost = request.getParameter("repairCost");
        String partCost = request.getParameter("partCost");
        String repairHours = request.getParameter("repairHours");
        Date acceptanceDateDate, planningStartDateDate, startRepairDate;
        int idId;
        int employee_idId;
        int vehicle_idId;
        double repairCostDouble;
        BigDecimal repairCostDec;
        double partCostDouble;
        BigDecimal partCostCostDec;
        int repairHoursHours;
        try {
            idId = Integer.parseInt(id);

            acceptanceDateDate = Date.valueOf(acceptanceDate);
            planningStartDateDate = Date.valueOf(planningStartDate);
            startRepairDate = Date.valueOf(startRepair);
            employee_idId = Integer.parseInt(employee_id);
            vehicle_idId = Integer.parseInt(vehicle_id);
            repairCostDouble = Double.parseDouble(repairCost);
            repairCostDec = BigDecimal.valueOf(repairCostDouble);
            partCostDouble = Double.parseDouble(partCost);
            partCostCostDec = BigDecimal.valueOf(partCostDouble);
            repairHoursHours = Integer.parseInt(repairHours);

            OrdersDao ordersDao = new OrdersDao(idId, acceptanceDateDate, planningStartDateDate, startRepairDate, employee_idId, problemDescription, repairDescription, status, vehicle_idId, repairCostDec, partCostCostDec, repairHoursHours);
            ordersDao.editOrder();
          //  response.getWriter().append("Edited order " +id +"   " + problemDescription);
            request.setAttribute("id", id);
            response.sendRedirect("/editedOrder.jsp?id="+id);

        } catch (Exception e) { e.printStackTrace(); response.getWriter().append("Cannot edit order!"); }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");
        request.getRequestDispatcher("/editorderform.jsp").forward(request, response);
    }

}
