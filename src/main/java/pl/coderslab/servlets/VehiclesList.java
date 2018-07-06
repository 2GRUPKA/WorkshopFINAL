package pl.coderslab.servlets;

import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "VehiclesList", urlPatterns = "/VehiclesList")
public class VehiclesList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<VehiclesDao> allVehicles;
        try {
            allVehicles = VehiclesDao.loadAllVehs();
            request.setAttribute("allVehicles", allVehicles);
        } catch (SQLException e){
            response.getWriter().append("sql problem");
        }
        request.getRequestDispatcher("vehicles/VehiclesList.jsp").forward(request, response);
    }
}
