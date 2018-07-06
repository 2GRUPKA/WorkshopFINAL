package pl.coderslab.dao;


import pl.coderslab.Classes.Employees;
import pl.coderslab.DbUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class EmployeesDao extends Employees {

    public EmployeesDao() {

    }

    public EmployeesDao(String name, String lastName, String address, String phone, String note, BigDecimal hourlyPayment) {
        super(name,lastName,address,phone,note,hourlyPayment);
    }



    // non-static DB methods
    public void saveToDB(){
        if(this.getId()==0){
            try {
                Connection conn = DbUtil.getConn();
                String generatedColumns[] = { "id" };
                String query = "INSERT INTO employees(name, lastName, address, phone, note, hourlyPayment) VALUES (?,?,?,?,?,?)";
                PreparedStatement stmt = DbUtil.getConn().prepareStatement(query,generatedColumns);
                stmt.setString(1, this.getName());
                stmt.setString(2, this.getLastName());
                stmt.setString(3, this.getAddress());
                stmt.setString(4, this.getPhone());
                stmt.setString(5, this.getNote());
                stmt.setBigDecimal(6, this.getHourlyPayment());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    this.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }else{
            try{
                PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE employees SET name=?, lastName=?, address=?, phone=?, note=?, hourlyPayment=? WHERE id=?");
                stmt.setString(1, this.getName());
                stmt.setString(2, this.getLastName());
                stmt.setString(3, this.getAddress());
                stmt.setString(4, this.getPhone());
                stmt.setString(5, this.getNote());
                stmt.setBigDecimal(6, this.getHourlyPayment());
                stmt.setInt(7, this.getId());
                stmt.executeUpdate();
            }catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public void delete(){
        String sql = "DELETE FROM employees WHERE id= ?";
        try{
            if(this.getId()!=0){
                PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
                stmt.setLong(1, this.getId());
                stmt.executeUpdate();
                setId(0);
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    // static DB methods

    public static ArrayList<EmployeesDao> loadAll() throws SQLException {
        String sql = "SELECT * FROM employees";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getEmployeesFromStatement(stmt);
    }
    private static ArrayList<EmployeesDao> getEmployeesFromStatement(PreparedStatement stmt) {
        try {
            ArrayList<EmployeesDao> employeeDao = new ArrayList<EmployeesDao>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                EmployeesDao loadedEmployee = new EmployeesDao();
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
    public static EmployeesDao loadById(int id){
        try {
            String sql = "SELECT * FROM employees WHERE id=?";
            PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                EmployeesDao loadedEmployee = new EmployeesDao();
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setLastName(resultSet.getString("lastName"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("phone"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setHourlyPayment(resultSet.getBigDecimal("hourlyPayment"));
                return loadedEmployee;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    public void updateEmployee() {

        try{
            Connection conn = DbUtil.getConn();
            PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE employees SET name=?, lastName=?, address=?, phone=?, note=?, hourlyPayment=? WHERE id=?");
            stmt.setString(1, this.getName());
            stmt.setString(2, this.getLastName());
            stmt.setString(3, this.getAddress());
            stmt.setString(4, this.getPhone());
            stmt.setString(5, this.getNote());
            stmt.setBigDecimal(6, this.getHourlyPayment());
            stmt.setInt(7, this.getId());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<OrdersDao> loadOrdersEmployee(int id) {
        try{
            String sql = "SELECT orders.id, orders.status, orders.vehicle_id, orders.problemDescription FROM orders LEFT JOIN employees ON orders.employee_id = employees.id WHERE employee_id = ?";
            PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
            ArrayList<OrdersDao> loadedOrders = new ArrayList<>();
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()) {
                OrdersDao loadedOrder = new OrdersDao();
                loadedOrder.setId(resultSet.getInt("orders.id"));
                loadedOrder.setStatus(resultSet.getString("orders.status"));
                loadedOrder.setVehicle_id(resultSet.getInt("orders.vehicle_id"));
                loadedOrder.setProblemDescription(resultSet.getString("orders.problemDescription"));
                loadedOrders.add(loadedOrder);
            }
            return loadedOrders;
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}