package pl.coderslab.servlets;


import pl.coderslab.dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "VehicleEdit", urlPatterns = "/VehicleEdit")
public class VehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Date productionYear = Date.valueOf(request.getParameter("productionYear"));
        String registrationNumber = request.getParameter("registrationNumber");
        Date nextRepairDate = Date.valueOf(request.getParameter("nextRepairDate"));
        String client_string = request.getParameter("client_id");

        try {
            int id = Integer.parseInt(idStr);
            int client_id = Integer.parseInt(client_string);
            VehiclesDao vehicle1;
            vehicle1 = VehiclesDao.loadVehiclebyId(id);
            if (model!=null)vehicle1.setModel(model);
            if (brand!=null)vehicle1.setBrand(brand);
            if (productionYear!=null)vehicle1.setProductionYear(productionYear);
            if (registrationNumber!=null)vehicle1.setRegistrationNumber(registrationNumber);
            if (nextRepairDate!=null)vehicle1.setNextRepairDate(nextRepairDate);
            if (client_id!=0)vehicle1.setClient_id(client_id);
            vehicle1.editVeh();
            response.getWriter().append("Eddited " +brand+" "+model + " with id: " +id);
        } catch (Exception e){
            response.getWriter().append("Cannot edit this vehicle! Reason: " );
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String editstr = request.getParameter("id");
        if (editstr!=null && !editstr.isEmpty()){
            int editId = Integer.parseInt(editstr);
            VehiclesDao loadedVeh = VehiclesDao.loadVehiclebyId(editId);
            request.setAttribute("vehicle", loadedVeh);
        }
        request.getRequestDispatcher("vehicles/vehicleEdit.jsp").forward(request, response);

    }

}
