package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import pl.coderslab.dao.clientsDao;


@WebServlet(name = "EditClient",urlPatterns = "/EditClient")
public class EditClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String date = request.getParameter("birthDate");
        Date birthDate = Date.valueOf(date);
        int id;
        try {
            id = Integer.parseInt(idStr);
            clientsDao ClientsDao = clientsDao.loadbyId(id);
            ClientsDao.editClients();
            ClientsDao.saveClients();

        } catch (Exception e) {
            response.getWriter().append("Could not edit the client");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("clients/clientToEdit.jsp").forward(request, response);

    }
}
