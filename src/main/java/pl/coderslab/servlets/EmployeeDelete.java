package pl.coderslab.servlets;

import pl.coderslab.Classes.Employees;
import pl.coderslab.dao.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

@WebServlet(name = "EmployeeDelete", urlPatterns = "/employeeDelete")
public class EmployeeDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8;");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        int idInt;

        if (!id.isEmpty() && id != null) {
            try {
                idInt = Integer.parseInt(id);
                EmployeesDao employeesDao = new EmployeesDao();
                employeesDao = EmployeesDao.loadById(idInt);
                employeesDao.delete();
                response.getWriter().append("You deleted employee with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("Nie wpisano poprawnego id");
        }

//            while(scanner.hasNext()) {
//                    while(true) {
//                    if(scanner.nextLine().equals("Y")) {
//                        employeesDao.delete();
//                    }
//                    else if (scanner.nextLine().equals("N")) {
//                        return;
//                    }
//                }
//            }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8;");
        try {
            ArrayList<EmployeesDao> listEmp = EmployeesDao.loadAll();
            request.setAttribute("listEmp", listEmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/employees/delete.jsp").forward(request, response);
    }
}