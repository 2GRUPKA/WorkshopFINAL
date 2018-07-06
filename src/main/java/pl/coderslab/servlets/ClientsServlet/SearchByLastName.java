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

@WebServlet(name = "SearchByLastName",urlPatterns = "/Search")
public class SearchByLastName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String lastName = request.getParameter("lastName");
//        Scanner scan = new Scanner(System.in);

        if (!lastName.isEmpty() && lastName != null) {
            try {
                clientsDao ClientsDao = new clientsDao(lastName);
                ClientsDao = clientsDao.searchByLastName(lastName);
//                ClientsDao.deleteFromClients();
                response.sendRedirect("/clientsList.jsp?lastName="+lastName);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("The last name you have entered does not exisit in our system ");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ArrayList<clientsDao> searchClients = clientsDao.loadAll();
            request.setAttribute("search",searchClients);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/clients/clientsList.jsp").forward(request,response);

    }
}
