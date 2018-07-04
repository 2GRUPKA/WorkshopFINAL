package pl.coderslab.dao;


import pl.coderslab.Classes.Employees;
import pl.coderslab.DbUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class EmployeesDao extends Employees {

    public EmployeesDao(String name, String lastName, String address, String phone, String note, BigDecimal hourlyPayment) {
        super(name,lastName,address,phone,note,hourlyPayment);
    }


//    @Override
//    public String toString(){
//        return "id: " +this.getId()+" name, surname: "+this.getName()+" "+this.getLastName()+ " address: " + this.getAddress() + " phone:" + this.getPhone() + " note: "
//                + this.getNote() + " hourly payment: " + this.getHourlyPayment();
//    }


    // non-static DB methods
    public void saveToDB(){
        if(this.getId()==0){
            try {
//                Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
                Connection conn = DbUtil.getConn();
                String generatedColumns[] = { "id" };
                String query = "INSERT INTO employees(name, lastName, address, phone, note, hourlyPayment) VALUES (?,?,?,?,?,?)";
                PreparedStatement stmt = DbUtil.getConn().prepareStatement(query,generatedColumns);
//                PreparedStatement stmt = connection.prepareStatement(query,generatedColumns);
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
//                Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
                PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE employees SET name=?, lastName=?, address=?, phone=?, note=?, hourlyPayment=? WHERE id=?");
//                PreparedStatement stmt = connection.prepareStatement("UPDATE employees SET name=?, lastName=?, address=?, phone=?, note=?, hourlyPayment=? WHERE id=?");
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
//                Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
                PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
//                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setLong(1, this.getId());
                stmt.executeUpdate();
                setId(0);
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    // static DB methods

    public static ArrayList<Employees> loadAll() throws SQLException {
        String sql = "SELECT * FROM employees";
//        Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
//        PreparedStatement stmt = connection.prepareStatement(sql);
        return getEmployeesFromStatement(stmt);
    }
    private static ArrayList<Employees> getEmployeesFromStatement(PreparedStatement stmt) {
        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
            ArrayList<Employees> employee = new ArrayList<Employees>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Employees loadedEmployee = new Employees();
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setLastName(resultSet.getString("lastName"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("phone"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setHourlyPayment(resultSet.getBigDecimal("hourlyPayment"));
                employee.add(loadedEmployee);
            }
            return employee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static Employees loadById(int id){
        try {
            String sql = "SELECT * FROM employees WHERE id=?";
//            Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
            PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
//            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Employees loadedEmployee = new Employees();
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
}

