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

@WebServlet(name = "OrdersDelete", urlPatterns = "/deleteOrder")
public class OrdersDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idInt;
        if(!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                OrdersDao ordersDao = new OrdersDao();
                ordersDao = OrdersDao.loadById(idInt);
                ordersDao.delete();
                response.getWriter().append("You deleted order with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("Nie wpisano poprawnego id");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8;");
        try {
            response.getWriter().append(OrdersDao.loadAll().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().append("<form method='post' action=''>")
                .append("<div> <label> Type id order to delete </div>")
                .append("<input type='number' name='id' min=0 /></label>")
                .append("</label> <input type='submit' value='submit'/> </form>");
    }
    }
}
