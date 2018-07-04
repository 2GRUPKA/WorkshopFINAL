package pl.coderslab.servlets;

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

@WebServlet(name = "EmployeeList", urlPatterns = "/employeeList")
public class EmployeeList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");
        response.getWriter().append("<h3>List employees in workshop: ");

        try {
            ArrayList<EmployeesDao> list = EmployeesDao.loadAll();
            Iterator<EmployeesDao> it = list.iterator();
            response.getWriter().append("<ol>");
            while(it.hasNext()) {
                response.getWriter().append("<li>"+it.next().toString()+"</li>");
            }
            response.getWriter().append("</ol>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
