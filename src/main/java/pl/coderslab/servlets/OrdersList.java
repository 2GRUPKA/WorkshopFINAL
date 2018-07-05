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
import java.util.Iterator;

@WebServlet(name = "OrdersList", urlPatterns = "/OrdersList")
public class OrdersList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");

        try {
            ArrayList<OrdersDao> listao = OrdersDao.loadAll();
            request.setAttribute("listao", listao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/orderslist.jsp").forward(request, response);

    }
}
