package pl.coderslab.dao;

import pl.coderslab.Classes.Vehicles;
//import pl.coderslab.DatabaseCon;
import pl.coderslab.DbUtil;

import java.sql.*;
import java.util.ArrayList;

import pl.coderslab.DbUtil;

public class VehiclesDao extends Vehicles {


    public VehiclesDao(String model, String brand, Date productionYear, String registrationNumber, Date nextRepairDate) {
        super(model, brand, productionYear, registrationNumber, nextRepairDate);
    }

    public VehiclesDao() {
        super();
    }

    public void saveVeh() {
        if (getId() == 0) {
            try {
                Connection conn = DbUtil.getConn();
                String generatedColumns[] = {"ID"};
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO vehicles (model,brand,productionYear,registrationNumber,nextRepairDate) VALUES (?,?,?,?,?)", generatedColumns);
                stmt.setString(1, getModel());
                stmt.setString(2, getBrand());
                stmt.setDate(3, getProductionYear());
                stmt.setString(4, getRegistrationNumber());
                stmt.setDate(5, getNextRepairDate());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                Connection conn = DbUtil.getConn();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO vehicles (model=?,brand=?,productionYear=?,registrationNumber=?,nextRepairDate=? WHERE id=?");
                stmt.setString(1, getModel());
                stmt.setString(2, getBrand());
                stmt.setDate(3, getProductionYear());
                stmt.setString(4, getRegistrationNumber());
                stmt.setDate(5, getNextRepairDate());
                stmt.setLong(6, getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }




    public void deleteVeh(){
        String sql = "DELETE FROM vehicles WHERE id= ?";
        try{
            if(getId()!=0){
                Connection conn = DbUtil.getConn();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setLong(1, getId());
                stmt.executeUpdate();
                setId(0);
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void editVeh() {
        try {
            Connection conn = DbUtil.getConn();
            String Columns[] = {"ID"};
            PreparedStatement stat = conn.prepareStatement("UPDATE vehicles SET model = ?, brand = ?, productionYear = ?, registrationNumber=?,nextRepairDate=? WHERE id=?");
            stat.setString(1, getModel());
            stat.setString(2, getBrand());
            stat.setDate(3, getProductionYear());
            stat.setString(4, getRegistrationNumber());
            stat.setDate(5, getNextRepairDate());
            stat.setInt(6, getId());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error! Could not complete the edit request");
        }
    }

    public static VehiclesDao loadVehiclebyId(int id) {
        try {
            String sql = "SELECT * FROM vehicles WHERE id=?";
            PreparedStatement stat = DbUtil.getConn().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                VehiclesDao loadedVehicle = new VehiclesDao();
                loadedVehicle.setModel(rs.getString("model"));
                loadedVehicle.setBrand(rs.getString("brand"));
                loadedVehicle.setProductionYear(rs.getDate("productionYear"));
                loadedVehicle.setRegistrationNumber(rs.getString("registrationNumber"));
                loadedVehicle.setNextRepairDate(rs.getDate("nextRepairDate"));
                loadedVehicle.setId(rs.getInt("id"));
                return loadedVehicle;
            }
        } catch (SQLException e) {
            System.out.println("Error loading Vehicles");
        }
        return null;
    }

    public static ArrayList<VehiclesDao> loadAllVehs() throws SQLException {
        String sql = "SELECT * FROM vehicles";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getVehiclesFromStatement(stmt);
    }

    private static ArrayList<VehiclesDao> getVehiclesFromStatement(PreparedStatement stmt) {
        try {
            ArrayList<VehiclesDao> vehicles = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VehiclesDao loadedVehicle = new VehiclesDao();
                loadedVehicle.setModel(rs.getString("model"));
                loadedVehicle.setBrand(rs.getString("brand"));
                loadedVehicle.setProductionYear(rs.getDate("productionYear"));
                loadedVehicle.setRegistrationNumber(rs.getString("registrationNumber"));
                loadedVehicle.setNextRepairDate(rs.getDate("nextRepairDate"));
                loadedVehicle.setId(rs.getInt("id"));
                vehicles.add(loadedVehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            System.err.println("Error getting clients from the list!");
        }
        return null;

    }

    public static ArrayList<OrdersDao> loadVehicleRepairs(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE vehicle_id="+id;
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getVehicleRepairs(stmt);
    }

    private static ArrayList<OrdersDao> getVehicleRepairs(PreparedStatement stmt) {
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

}
