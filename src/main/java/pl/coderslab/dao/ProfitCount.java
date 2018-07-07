package pl.coderslab.dao;

import pl.coderslab.DbUtil;
import pl.coderslab.dao.OrdersDao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static pl.coderslab.dao.OrdersDao.getOrdersFromStatement;
import static pl.coderslab.dao.OrdersDao.loadByEmployeeId;

public class ProfitCount {
    private Date since;
    private Date till;


    public ProfitCount(Date since, Date till) {
        this.since = since;
        this.till = till;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till)  {
        this.till = till;
    }
    public ArrayList<OrdersDao> loadOrdersByDate(Date since, Date till) throws SQLException {
        String sql = "SELECT * FROM orders WHERE startRepair >=? AND startRepair <=?;";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        stmt.setDate(1, since);
        stmt.setDate(2, till);

        return getOrdersFromStatement(stmt);
    }

    public  BigDecimal employeesCost (int repairHours, int employeeId)throws SQLException{
        String sql = "SELECT hourlyPayment FROM employees WHERE id=?";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        stmt.setInt(1, employeeId);
        int hourlyPayment = stmt.executeUpdate();
        return BigDecimal.valueOf(repairHours * hourlyPayment);
    }

    public BigDecimal orderProfit(OrdersDao order) throws SQLException {
        int repairHours = order.getRepairHours();
        BigDecimal income = order.getRepairCost();
        BigDecimal partCost = order.getPartCost();
        int employeeId = order.getEmployee_id();
        BigDecimal employeeCost = employeesCost(repairHours, employeeId);
        BigDecimal cost = partCost.add(employeeCost);
        return income.subtract(cost);
    }

    public BigDecimal totalIncome(ArrayList<OrdersDao> orders) throws SQLException {
        BigDecimal income = null;
        for (OrdersDao order: orders) {
            income.add(orderProfit(order));
        }
        return income;
    }


}