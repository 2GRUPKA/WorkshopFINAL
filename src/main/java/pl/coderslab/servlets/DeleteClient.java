package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

import pl.coderslab.dao.clientsDao;


@WebServlet(name = "DeleteClient", urlPatterns = "/DeleteClient")
public class DeleteClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Scanner scan = new Scanner(System.in);
        int idInt;

        if (!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                clientsDao ClientsDao = new clientsDao();
                ClientsDao = clientsDao.loadbyId(idInt);
                ClientsDao.deleteFromClients();
                response.getWriter().append("You have deleted the client with id: " + id);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("You have entered an incorrect id");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/ClientToDelete.jsp").forward(request, response);

    }
}
