package pl.coderslab.servlets.ClientsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import pl.coderslab.dao.VehiclesDao;



@WebServlet(name = "ClientsJoinVehicles",urlPatterns = "/ClientsJoinVehicles")
public class ClientsJoinVehicles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int intId;
        try {
            intId = Integer.parseInt(id);
            ArrayList<VehiclesDao> list = VehiclesDao.loadByClientId(intId);
            request.setAttribute("list",list);
        }catch (SQLException e){
            System.out.println("The thing you're looking for does not exist HA HA HA");
        }
        request.getRequestDispatcher("/clients/ClientsJoinVehicles.jsp").forward(request,response);
    }
}


