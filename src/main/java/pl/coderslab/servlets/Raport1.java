package pl.coderslab.servlets;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.RaportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Raport1", urlPatterns = "/raport1")
public class Raport1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8;");

        try {
            ArrayList<RaportDao> raportt = RaportDao.raport1();
            request.setAttribute("raportt", raportt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/raportlist.jsp").forward(request, response);
    }
}
