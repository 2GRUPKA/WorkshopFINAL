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

@WebServlet(name = "VehicleDelete", urlPatterns =   "/VehicleDelete")
public class VehicleDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idStr);
            if (id!=0){
                VehiclesDao veh1 = VehiclesDao.loadVehiclebyId(id);
                veh1.deleteVeh();
                request.setAttribute("id", id);
                response.sendRedirect("/vehicles/youDeletedVeh.jsp?id="+id);
            }
        } catch (Exception e){
            response.getWriter().append("wrong id");
            e.printStackTrace();
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
