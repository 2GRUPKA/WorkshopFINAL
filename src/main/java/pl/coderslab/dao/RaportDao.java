package pl.coderslab.dao;

import pl.coderslab.Classes.Employees;
import pl.coderslab.DbUtil;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RaportDao extends Employees {
    public void setHours(int hours) {
        this.hours = hours;
    }

    private int hours;

    public int getHours() {
        return hours;
    }

    public RaportDao() {

    }

    public RaportDao(String name, String lastName, String address, String phone, String note, BigDecimal hourlyPayment, int hours) {
        super(name,lastName,address,phone,note,hourlyPayment);
        this.hours = hours;
    }
    public static ArrayList<RaportDao> raport1() throws SQLException {

        String sql = "    SELECT repairHours FROM orders LEFT  JOIN employees ON\n" +
                "    employees.id=orders.employee_id";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getEmployeesFromStatement(stmt);
    }
    private static ArrayList<RaportDao> getEmployeesFromStatement(PreparedStatement stmt) {
        try {
            ArrayList<RaportDao> employeeDao = new ArrayList<RaportDao>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                RaportDao loadedEmployee = new RaportDao();
                loadedEmployee.setHours(resultSet.getInt("repairHours"));
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setLastName(resultSet.getString("lastName"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("phone"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setHourlyPayment(resultSet.getBigDecimal("hourlyPayment"));



                employeeDao.add(loadedEmployee);
            }
            return employeeDao;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
