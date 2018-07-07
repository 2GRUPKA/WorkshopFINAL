package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeesDao;
import pl.coderslab.dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "EmployeeOrders", urlPatterns = "/employeeOrders")
public class EmployeeOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // response.setContentType("text/html; charset=utf-8;");
      //  request.setCharacterEncoding("UTF-8");
//
//        String idStr = request.getParameter("id");
//        int id;
//        try {
//            id = Integer.parseInt(idStr);
//            ArrayList<OrdersDao> listOrders = EmployeesDao.loadOrdersEmployee(id);
//            Iterator<OrdersDao> it = listOrders.iterator();
//            while(it.hasNext()) {
//                response.getWriter().append("status= " + it.next().getStatus() + " vehicle id = " +
//                        it.next().getVehicle_id() + "id order = " + it.next().getId());
//            }
//            request.setAttribute("listOrders", listOrders);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().append("Wrong id");
//        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idStr);
            ArrayList<OrdersDao> listEO = OrdersDao.loadByEmployeeId(id);
            request.setAttribute("listEO", listEO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/employees/ordersEmp.jsp").forward(request, response);


    }
}
