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

        String id = request.getParameter("id");
        int idInt;

        if(!id.isEmpty() && id != null) {
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
            ArrayList<EmployeesDao> list = EmployeesDao.loadAll();
            Iterator<EmployeesDao> it = list.iterator();
            response.getWriter().append("<ol>");
            while(it.hasNext()) {
                response.getWriter().append("<li>"+it.next().toString()+"</li>");
            }
            response.getWriter().append("</ol>");
        } catch (SQLException e) {
            response.getWriter().append("Brak pracowników");
            e.printStackTrace();
        }
        response.getWriter().append("<form method='post' action=''>")
                    .append("<div> <label> Type id employee to delete </div>")
                    .append("<input type='number' name='id' min=0 /></label>")
                    .append("</label> <input type='submit' value='submit'/> </form>");
    }
}
