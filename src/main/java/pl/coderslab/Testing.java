package pl.coderslab;

import pl.coderslab.dao.EmployeesDAO;

import java.math.BigDecimal;
import java.sql.*;


public class Testing {

    public static void main(String[] args) {

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7245922", "sql7245922", "KTdz9mTYra");
//            String sql = "SELECT * FROM employees";
//            PreparedStatement prm = connection.prepareStatement(sql);
//            prm.executeQuery();
//            ResultSet rs = prm.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                System.out.println(id);
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}

        try {
            Connection conn = DbUtil.getConn();
            conn.prepareStatement("SELECT * FROM employees");
        } catch (SQLException e) {
            e.printStackTrace();

        }
//        EmployeesDAO jan = new EmployeesDAO("Jeman", "Kojjjwlski", "12jj3123", "123123", "asdasdas", BigDecimal.valueOf(10.2));
//        jan.saveToDB();
    }
}