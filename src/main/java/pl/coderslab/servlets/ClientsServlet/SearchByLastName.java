package pl.coderslab.servlets.ClientsServlet;

import pl.coderslab.dao.clientsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "SearchByLastName", urlPatterns = "/SearchByLastName")
public class SearchByLastName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        try {
            clientsDao ClientsDao = new clientsDao();
            ClientsDao = clientsDao.searchByLastName(lastName);
            request.setAttribute("ClientsDao", ClientsDao);
            request.getRequestDispatcher("/clients/show.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8;");

        try {
            ArrayList<clientsDao> list = clientsDao.loadAll();
            request.setAttribute("list", list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/clients/clientsByLastName.jsp").forward(request, response);


    }

}
