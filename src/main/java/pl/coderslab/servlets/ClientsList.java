package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import pl.coderslab.dao.clientsDao;


@WebServlet(name = "ClientsList",urlPatterns = "/ClientsList")
public class ClientsList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<clientsDao> listClients = clientsDao.loadAll();
            request.setAttribute("listClients", listClients);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        request.getRequestDispatcher("/clients/clientsList.jsp").forward(request, response);


    }
}
