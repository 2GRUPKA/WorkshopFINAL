package pl.coderslab.servlets.ClientsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import pl.coderslab.dao.clientsDao;


@WebServlet(name = "AddClient", urlPatterns = "/AddClient")
public class AddClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String date = request.getParameter("birthDate");
        Date birthDate = Date.valueOf(date);

        try {
            clientsDao clientsDao = new clientsDao(name, lastName, birthDate);
            clientsDao.saveClients();
            response.getWriter().append("Added new client " + name + " " + lastName);


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append("Cannot add a new client!");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/clients/clients.jsp").forward(request, response);


    }
}