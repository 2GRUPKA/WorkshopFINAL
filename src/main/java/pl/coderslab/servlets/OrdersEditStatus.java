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

@WebServlet(name = "OrdersEditStatus", urlPatterns = "/editOrderStatus")
public class OrdersEditStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String status = request.getParameter("status");
        int idId;
        try {
            idId = Integer.parseInt(id);
            OrdersDao ordersDao = new OrdersDao(idId, status);
            ordersDao.editOrder();
            //  response.getWriter().append("Edited order " +id +"   " + problemDescription);
            request.setAttribute("id", id);
            response.sendRedirect("/editedOrder.jsp?id="+id);

        } catch (Exception e) { e.printStackTrace(); response.getWriter().append("Cannot edit order!"); }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");
        request.getRequestDispatcher("/editorderstatus.jsp").forward(request, response);
    }

}
