package pl.coderslab.servlets.ClientsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.coderslab.dao.clientsDao;


@WebServlet(name = "DeleteClient", urlPatterns = "/DeleteClient")
public class DeleteClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
//        Scanner scan = new Scanner(System.in);
        int idInt;

        if (!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                clientsDao ClientsDao = new clientsDao(idInt);
                ClientsDao = clientsDao.loadbyId(idInt);
                ClientsDao.deleteFromClients();
                request.setAttribute("id",idInt);
                response.sendRedirect("/delete.jsp?id=?"+idInt);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("You have entered an incorrect id");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ArrayList<clientsDao> listClients = clientsDao.loadAll();
            request.setAttribute("list",listClients);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/clients/ClientToDelete.jsp").forward(request,response);
    }
}
