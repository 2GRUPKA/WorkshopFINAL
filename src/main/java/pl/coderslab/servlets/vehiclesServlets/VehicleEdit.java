package pl.coderslab.servlets.vehiclesServlets;


import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/VehicleEdit")
public class VehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Date productionYear = Date.valueOf(request.getParameter("productionYear"));
        String registrationNumber = request.getParameter("registrationNumber");
        Date nextRepairDate = Date.valueOf(request.getParameter("nextRepairDate"));

        try {
            int id = Integer.parseInt(idStr);
            VehiclesDao vehicle1;
            vehicle1 = VehiclesDao.loadVehiclebyId(id);
            if (model!=null)vehicle1.setModel(model);
            if (brand!=null)vehicle1.setBrand(brand);
            if (productionYear!=null)vehicle1.setProductionYear(productionYear);
            if (registrationNumber!=null)vehicle1.setRegistrationNumber(registrationNumber);
            if (nextRepairDate!=null)vehicle1.setNextRepairDate(nextRepairDate);
            vehicle1.editVeh();
            response.getWriter().append("Eddited " +brand+" "+model + " with id: " +id);
        } catch (Exception e){
            response.getWriter().append("Cannot edit this vehicle! Reason: " + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vehicles/vehicleEdit.jsp").forward(request, response);

    }
}
