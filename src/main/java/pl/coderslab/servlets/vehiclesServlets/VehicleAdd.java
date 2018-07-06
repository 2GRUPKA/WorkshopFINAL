package pl.coderslab.servlets.vehiclesServlets;

import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/VehicleAdd")
public class VehicleAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Date productionYear = Date.valueOf(request.getParameter("productionYear"));
        String registrationNumber = request.getParameter("registrationNumber");
        Date nextRepairDate = Date.valueOf(request.getParameter("nextRepairDate"));

        try {
            VehiclesDao veh = new VehiclesDao(model, brand, productionYear, registrationNumber, nextRepairDate);
            veh.saveVeh();
            response.getWriter().append(brand + " " + model + " with registration number: " + registrationNumber + " added.");
        } catch (Exception e){
            response.getWriter().append("Cannot add this vehicle. Reason: " + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vehicles/vehicleAdd.jsp").forward(request, response);
    }
}
