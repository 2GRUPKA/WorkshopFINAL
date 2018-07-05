package pl.coderslab.servlets;

import pl.coderslab.Classes.Orders;
import pl.coderslab.dao.EmployeesDao;
import pl.coderslab.dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "OrdersDelete", urlPatterns = "/deleteOrder")
public class OrdersDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("idtodelete");
        int idInt;
        if(!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                OrdersDao ordersDao = new OrdersDao();
                ordersDao = OrdersDao.loadById(idInt);
                ordersDao.delete();
                request.setAttribute("id", idInt);
                response.sendRedirect("/deletedOrder.jsp?id="+idInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("Wrong id");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8;");
//        try {
//            response.getWriter().append(OrdersDao.loadAll().toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            ArrayList<OrdersDao> listao = OrdersDao.loadAll();
            request.setAttribute("listao", listao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/deleteorderform.jsp").forward(request, response);


    }
}
