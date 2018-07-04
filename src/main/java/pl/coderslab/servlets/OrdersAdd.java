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

@WebServlet(name = "OrdersAdd", urlPatterns = "/addOrder")
public class OrdersAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        try {
            Date acceptanceDateDate = Date.valueOf(acceptanceDate);
            Date planningStartDateDate = Date.valueOf(planningStartDate);
            Date startRepairDate = Date.valueOf(startRepair);
            int employee_idId = Integer.parseInt(employee_id);
            int vehicle_idId = Integer.parseInt(vehicle_id);
            double repairCostDouble = Double.parseDouble(repairCost);
            BigDecimal repairCostDec = BigDecimal.valueOf(repairCostDouble);
            double partCostDouble = Double.parseDouble(partCost);
            BigDecimal partCostCostDec = BigDecimal.valueOf(partCostDouble);
            int repairHoursHours = Integer.parseInt(repairHours);

            OrdersDao ordersDao = new OrdersDao(acceptanceDateDate, planningStartDateDate, startRepairDate, employee_idId, problemDescription, repairDescription, status, vehicle_idId, repairCostDec, partCostCostDec, repairHoursHours);
            ordersDao.saveToDB();
           //response.getWriter().append("Added new employee " + acceptanceDateDate, planningStartDateDate, startRepairDate, employtee_idId, problemDescription, repairDescription, status, vehicle_idId, repairCostDec, partCostCostDec, repairHoursHours);
            response.getWriter().append("Added new order " + ordersDao);

        } catch (Exception e) { e.printStackTrace(); response.getWriter().append("Cannot add new order!"); }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");
        response.getWriter().append("    <form action='' metod=\"post\"/>\n" +
                "        <div><input type='date' name='acceptanceDate' required /></div>\n" +
                "       <div> <input type='date' name='planningStartDate' required /></div>\n" +
                "        <div><input type='date' name='startRepair' required /></div>\n" +
                "        <div><input type='text' name='employee_id' required placeholder=\"employee_id\" /></div>\n" +
                "        <div><input type='text' name='problemDescription' required placeholder=\"problemDescription\" /></div>\n" +
                "        <div><input type='text' name='repairDescription' required placeholder=\"repairDescription\" /></div>\n" +
                "\n" +
                "        <div><input type='text' name='status' required placeholder=\"status\" /></div>\n" +
                "\n" +
                "        <div><input type='text' name='vehicle_id' required placeholder=\"vehicle_id\" /></div>\n" +
                "\n" +
                "        <div><input type='text' name='repairCost' required placeholder=\"repairCost\" /></div>\n" +
                "\n" +
                "        <div><input type='text' name='partCost' required placeholder=\"partCost\" /></div>\n" +
                "\n" +
                "        <div><input type='text' name='repairHours' required placeholder=\"repairHours\" /></div>\n" +
                "        <div><div><input type='submit' value='submit'/></div>\"\n" +
                "\n" +
                "    </form>");
        //request.getRequestDispatcher("/addorderform.jsp").forward(request, response);
    }
}
