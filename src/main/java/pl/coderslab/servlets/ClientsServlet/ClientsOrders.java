package pl.coderslab.servlets.ClientsServlet;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ClientsOrders", urlPatterns = "/ClientsOrders")
public class ClientsOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int intId;
        try {
            intId = Integer.parseInt(id);
            ArrayList<OrdersDao> list = OrdersDao.loadByVehicleId(intId);
            request.setAttribute("list", list);
        } catch (SQLException e) {
            System.out.println("The thing you're looking for does not exist");
        }
        request.getRequestDispatcher("/clients/ClientsJoinVehicles.jsp").forward(request, response);
    }
}

