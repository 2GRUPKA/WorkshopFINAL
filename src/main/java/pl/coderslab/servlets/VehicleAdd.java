package pl.coderslab.servlets;

import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "VehicleAdd", urlPatterns = "/VehicleAdd")
public class VehicleAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String productionYear = request.getParameter("productionYear");
        String registrationNumber = request.getParameter("registrationNumber");
        String nextRepairDate = request.getParameter("nextRepairDate");
        String client_string = request.getParameter("client_id");
        int client_id = Integer.parseInt(client_string);
        Date pY = Date.valueOf(productionYear);
        Date nX = Date.valueOf(nextRepairDate);

        try {
//            int client_id = Integer.parseInt(client_string);
//            Date pY = Date.valueOf(productionYear);
//            Date nX = Date.valueOf(nextRepairDate);
            VehiclesDao veh = new VehiclesDao(model, brand, pY, registrationNumber, nX, client_id);
                veh.saveVeh();
            response.getWriter().append(brand + " " + model + " with registration number: " + registrationNumber + " added.");
        } catch (Exception e){
            response.getWriter().append("Cannot add this vehicle. Reason: " +e);
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vehicles/vehicleAdd.jsp").forward(request, response);
    }
}
