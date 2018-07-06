package pl.coderslab.servlets.vehiclesServlets;

import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/VehicleDelte")
public class VehicleDelte extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idStr);
            VehiclesDao veh1 = VehiclesDao.loadVehiclebyId(id);
            veh1.deleteVeh();
            response.getWriter().append("Delated vehicle "+veh1.getBrand()+" "+veh1.getModel()+" with id: "+id);
        }catch (Exception e) {
            response.getWriter().append("Was not able to delete this vehicle. reason: " +e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<VehiclesDao> allVehicles;
        try {
            allVehicles = VehiclesDao.loadAllVehs();
            request.setAttribute("allVehicles", allVehicles);
        } catch (SQLException e){
            System.out.println(e);
        }
        request.getRequestDispatcher("vehicles/vehicleDelete.jsp").forward(request, response);
    }
}
