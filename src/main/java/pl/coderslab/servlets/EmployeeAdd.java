package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@WebServlet(name = "EmployeeAdd", urlPatterns = "/addEmployee")
public class EmployeeAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        String hourlyPayment = request.getParameter("hourlyPayment");
        double hourlyPaymentDouble;
        BigDecimal hourlyPaymentDecimal;

        try {
            hourlyPaymentDouble = Double.parseDouble(hourlyPayment);
            hourlyPaymentDecimal = BigDecimal.valueOf(hourlyPaymentDouble);
            EmployeesDao employeesDao = new EmployeesDao(name,lastName,address,phone,note,hourlyPaymentDecimal);
            employeesDao.saveToDB();
            response.getWriter().append("Added new employee " + name +" "+lastName);


        } catch (Exception e) { e.printStackTrace(); response.getWriter().append("Cannot add new employee!"); }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");
        response.getWriter().append("<form action='' method='post' />" +
                "<div><label>Name: <br><input type='text' name='name' required /> </label></div>" +
                "<div><label>Surname: <br><input type='text' name='lastName' required /> </label></div>" +
                "<div><label>Address: <br><input type='text' name='address' required /> </label></div>" +
                "<div><label>Phone number: <br><input type='text' name='phone' required /> </label></div>" +
                "<div><label>Note about employee: <br><input type='text' name='note' required /> </label></div>" +
                "<div><label>Hourly payment: <br><input type='number' name='hourlyPayment' min=0 required /> </label></div>" +
                "<div><input type='submit' value='submit'/>" +
                "</form>");


    }
}
