package pl.coderslab.servlets;

import pl.coderslab.dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "OrderDetails", urlPatterns = "/OrderDetails")
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idtoshow");
        int idInt;
        if(!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                OrdersDao ordersDao = new OrdersDao();
                ordersDao = OrdersDao.loadById(idInt);
                request.setAttribute("ordersDao", ordersDao);
                request.getRequestDispatcher("/detailsordershow.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("Wrong id");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");

        try {
            ArrayList<OrdersDao> listao = OrdersDao.loadAll();
            request.setAttribute("listao", listao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/detailsorder.jsp").forward(request, response);


    }
}
