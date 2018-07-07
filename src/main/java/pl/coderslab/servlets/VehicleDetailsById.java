package pl.coderslab.servlets;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VehicleDetailsById", urlPatterns = "/VehicleDetailsById")
public class VehicleDetailsById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idStr);
            VehiclesDao veh1 = VehiclesDao.loadVehiclebyId(id);
            ArrayList<OrdersDao> vehiclesRepairs = VehiclesDao.loadVehicleRepairs(id);
            request.setAttribute("reapirs", vehiclesRepairs);
            request.setAttribute("veh", veh1);
        } catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("vehicles/vehicleDetailsbyId.jsp").forward(request, response);
    }
}
