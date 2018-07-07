package pl.coderslab.dao;

import pl.coderslab.Classes.Orders;
import pl.coderslab.DbUtil;

import java.math.BigDecimal;
import java.sql.*;

import java.util.ArrayList;

public class OrdersDao extends Orders {
    public OrdersDao() {
    }

    public OrdersDao(Date acceptanceDate, Date planningStartDate, Date startRepair, int employee_id, String problemDescription, String repairDescription, String status, int vehicle_id, BigDecimal repairCost, BigDecimal partCost, int repairHours) {
        super(acceptanceDate, planningStartDate, startRepair, employee_id, problemDescription, repairDescription, status, vehicle_id, repairCost, partCost, repairHours);
    }
    public OrdersDao(int id, Date acceptanceDate, Date planningStartDate, Date startRepair, int employee_id, String problemDescription, String repairDescription, String status, int vehicle_id, BigDecimal repairCost, BigDecimal partCost, int repairHours) {
        super(id, acceptanceDate, planningStartDate, startRepair, employee_id, problemDescription, repairDescription, status, vehicle_id, repairCost, partCost, repairHours);
    }
    public OrdersDao(int id, String status) {
        super(id, status);
    }


    public void delete() {
        String sql = "DELETE FROM orders WHERE id= ?";
        try {
            if (this.getId() != 0) {
                PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
                stmt.setLong(1, this.getId());
                stmt.executeUpdate();
                setId(0);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public static ArrayList<OrdersDao> loadAll() throws SQLException {
        String sql = "SELECT * FROM orders ORDER BY acceptanceDate ASC";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getOrdersFromStatement(stmt);
    }

    protected static ArrayList<OrdersDao> getOrdersFromStatement(PreparedStatement stmt) {
        try {
            ArrayList<OrdersDao> orderDao = new ArrayList<OrdersDao>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                OrdersDao loadedOrder = new OrdersDao();

                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setAcceptanceDate(resultSet.getDate("acceptanceDate"));
                loadedOrder.setPlanningStartDate(resultSet.getDate("planningStartDate"));
                loadedOrder.setStartRepair(resultSet.getDate("startRepair"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
                loadedOrder.setProblemDescription(resultSet.getString("problemDescription"));
                loadedOrder.setRepairDescription(resultSet.getString("repairDescription"));
                loadedOrder.setStatus(resultSet.getString("status"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setRepairCost(resultSet.getBigDecimal("repairCost"));
                loadedOrder.setPartCost(resultSet.getBigDecimal("partCost"));
                loadedOrder.setRepairHours(resultSet.getInt("repairHours"));
                orderDao.add(loadedOrder);
            }
            return orderDao;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static ArrayList<OrdersDao>loadByEmployeeId(int employee_id)throws SQLException {
        String sql = "SELECT * FROM orders WHERE employee_id=?";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        stmt.setInt(1, employee_id);
        return getOrdersFromStatement(stmt);
    }
    public static ArrayList<OrdersDao>loadByVehicleId(int vehicle_id)throws SQLException {
        String sql = "SELECT * FROM orders WHERE vehicle_id=?";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        stmt.setInt(1, vehicle_id);
        return getOrdersFromStatement(stmt);
    }

//        try {
//            String sql = "SELECT * FROM orders WHERE employee_id=?";
//            PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
//            stmt.setInt(1, employee_id);
//            ResultSet resultSet = stmt.executeQuery();
//            while (resultSet.next()) {
//                OrdersDao loadedOrder = new OrdersDao();
//
//                loadedOrder.setId(resultSet.getInt("id"));
//                loadedOrder.setAcceptanceDate(resultSet.getDate("acceptanceDate"));
//                loadedOrder.setPlanningStartDate(resultSet.getDate("planningStartDate"));
//                loadedOrder.setStartRepair(resultSet.getDate("startRepair"));
//                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
//                loadedOrder.setProblemDescription(resultSet.getString("problemDescription"));
//                loadedOrder.setRepairDescription(resultSet.getString("repairDescription"));
//                loadedOrder.setStatus(resultSet.getString("status"));
//                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
//                loadedOrder.setRepairCost(resultSet.getBigDecimal("repairCost"));
//                loadedOrder.setPartCost(resultSet.getBigDecimal("partCost"));
//                loadedOrder.setRepairHours(resultSet.getInt("repairHours"));
//                return loadedOrder;
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//
//        return null;
//    }

    public static OrdersDao loadById(int id) {
        try {
            String sql = "SELECT * FROM orders WHERE id=?";
            PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                OrdersDao loadedOrder = new OrdersDao();

                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setAcceptanceDate(resultSet.getDate("acceptanceDate"));
                loadedOrder.setPlanningStartDate(resultSet.getDate("planningStartDate"));
                loadedOrder.setStartRepair(resultSet.getDate("startRepair"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
                loadedOrder.setProblemDescription(resultSet.getString("problemDescription"));
                loadedOrder.setRepairDescription(resultSet.getString("repairDescription"));
                loadedOrder.setStatus(resultSet.getString("status"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setRepairCost(resultSet.getBigDecimal("repairCost"));
                loadedOrder.setPartCost(resultSet.getBigDecimal("partCost"));
                loadedOrder.setRepairHours(resultSet.getInt("repairHours"));
                return loadedOrder;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    public void saveToDB() {
        if (this.getId() == 0) {
            try {
                Connection conn = DbUtil.getConn();
                String generatedColumns[] = {"id"};
                PreparedStatement stmt = DbUtil.getConn().prepareStatement("INSERT INTO orders(" +
                        "acceptanceDate, planningStartDate, startRepair, employee_id, problemDescription, repairDescription, status, vehicle_id,repairCost, partCost, repairHours) " +
                        "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", generatedColumns);
                stmt.setDate(1, this.getAcceptanceDate());
                stmt.setDate(2, this.getPlanningStartDate());
                stmt.setDate(3, this.getStartRepair());
                stmt.setInt(4, this.getEmployee_id());
                stmt.setString(5, this.getProblemDescription());
                stmt.setString(6, this.getRepairDescription());
                stmt.setString(7, this.getStatus());
                stmt.setInt(8, this.getVehicle_id());
                stmt.setBigDecimal(9, this.getRepairCost());
                stmt.setBigDecimal(10, getPartCost());
                stmt.setInt(11, this.getRepairHours());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    this.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                //System.err.println(e.getMessage("Error could not save order");
                System.out.println("Error could not save order");
            }
        }

//        else {
//            try {
//                PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE orders SET acceptanceDate = ?, planningStartDate = ?, startRepair = ?, employee_id = ?, problemDescription = ?, repairDescription = ?, status = ?, vehicle_id = ?,repairCost = ?, partCost = ?, repairHours = ? " +
//                        "WHERE id = ?");
//                stmt.setDate(1, this.getAcceptanceDate());
//                stmt.setDate(2, this.getPlanningStartDate());
//                stmt.setDate(3, this.getStartRepair());
//                stmt.setInt(4, this.getEmployee_id());
//                stmt.setString(5, this.getProblemDescription());
//                stmt.setString(6, this.getRepairDescription());
//                stmt.setString(7, this.getStatus());
//                stmt.setInt(8, this.getVehicle_id());
//                stmt.setBigDecimal(9, this.getRepairCost());
//                stmt.setBigDecimal(10, this.getPartCost());
//                stmt.setInt(11, this.getRepairHours());
//                stmt.setInt(12, this.getId());
//                stmt.executeUpdate();
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
    }
    public void editOrder() {
        try {
            Connection conn = DbUtil.getConn();
            String Columns[] = {"id"};
            PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE orders SET acceptanceDate = ?, planningStartDate = ?, startRepair = ?, employee_id = ?, problemDescription = ?, repairDescription = ?, status = ?, vehicle_id = ?,repairCost = ?, partCost = ?, repairHours = ? " +
                    "WHERE id = ?");
            stmt.setDate(1, this.getAcceptanceDate());
            stmt.setDate(2, this.getPlanningStartDate());
            stmt.setDate(3, this.getStartRepair());
            stmt.setInt(4, this.getEmployee_id());
            stmt.setString(5, this.getProblemDescription());
            stmt.setString(6, this.getRepairDescription());
            stmt.setString(7, this.getStatus());
            stmt.setInt(8, this.getVehicle_id());
            stmt.setBigDecimal(9, this.getRepairCost());
            stmt.setBigDecimal(10, this.getPartCost());
            stmt.setInt(11, this.getRepairHours());
            stmt.setInt(12, this.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error! Could not complete the edit request");
        }
    }
    public void editStatus() {
        try {
            Connection conn = DbUtil.getConn();
            String Columns[] = {"id"};
            PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE orders SET acceptanceDate = acceptanceDate, planningStartDate = planningStartDate, startRepair = startRepair, employee_id = employee_id, problemDescription = problemDescription, repairDescription = repairDescription, status = ?, vehicle_id = vehicle_id,repairCost = repairCost, partCost = partCost, repairHours = repairHours " +
                    "WHERE id = ?");
            stmt.setString(1, this.getStatus());
            stmt.setInt(2, this.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error! Could not complete the edit request");
        }
    }
}
