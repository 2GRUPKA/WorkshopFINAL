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
            String del = request.getParameter("delete");
            if (del!=null) {
                try {
                    int id = Integer.parseInt(del);
                    if (id != 0) {
                        VehiclesDao veh1 = VehiclesDao.loadVehiclebyId(id);
                        veh1.deleteVeh();
                        response.getWriter().append("Delated vehicle " + veh1.getBrand() + " " + veh1.getModel() + " with id: " + id);
                    }
                } catch (Exception e) {
                    response.getWriter().append("Was not able to delete this vehicle. reason: ");
                    e.printStackTrace();
                }
            }
            allVehicles = VehiclesDao.loadAllVehs();
            request.setAttribute("allVehicles", allVehicles);
        } catch (SQLException e){
            response.getWriter().append("sql problem");
        }
        request.getRequestDispatcher("vehicles/VehiclesList.jsp").forward(request, response);
    }
}
