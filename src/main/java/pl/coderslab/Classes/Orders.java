package pl.coderslab.Classes;

import java.math.BigDecimal;
import java.sql.Date;

public class Orders {

    private int id;
    private Date acceptanceDate;
    private Date planningStartDate;
    private Date startRepair;
    private int employee_id;

    public Orders(int id, String status) {
        this.id = id;
        this.status = status;
    }

    private String problemDescription;
    private String repairDescription;

    public Orders(int id, Date acceptanceDate, Date planningStartDate, Date startRepair, int employee_id, String problemDescription, String repairDescription, String status, int vehicle_id, BigDecimal repairCost, BigDecimal partCost, int repairHours) {
        this.id = id;
        this.acceptanceDate = acceptanceDate;
        this.planningStartDate = planningStartDate;
        this.startRepair = startRepair;
        this.employee_id = employee_id;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.repairCost = repairCost;
        this.partCost = partCost;
        this.repairHours = repairHours;
    }

    private String status;
    private int vehicle_id;
    private BigDecimal repairCost;
    private BigDecimal partCost;

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", acceptanceDate=" + acceptanceDate +
                ", planningStartDate=" + planningStartDate +
                ", startRepair=" + startRepair +
                ", employee_id=" + employee_id +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", status='" + status + '\'' +
                ", vehicle_id=" + vehicle_id +
                ", repairCost=" + repairCost +
                ", partCost=" + partCost +
                ", repairHours=" + repairHours +
                '}';
    }

    private int repairHours;

    public Orders(Date acceptanceDate, Date planningStartDate, Date startRepair, int employee_id, String problemDescription, String repairDescription, String status, int vehicle_id, BigDecimal repairCost, BigDecimal partCost, int repairHours) {
        this.acceptanceDate = acceptanceDate;
        this.planningStartDate = planningStartDate;
        this.startRepair = startRepair;
        this.employee_id = employee_id;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.repairCost = repairCost;
        this.partCost = partCost;
        this.repairHours = repairHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public Date getPlanningStartDate() {
        return planningStartDate;
    }

    public void setPlanningStartDate(Date planningStartDate) {
        this.planningStartDate = planningStartDate;
    }

    public Date getStartRepair() {
        return startRepair;
    }

    public void setStartRepair(Date startRepair) {
        this.startRepair = startRepair;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public BigDecimal getPartCost() {
        return partCost;
    }

    public void setPartCost(BigDecimal partCost) {
        this.partCost = partCost;
    }

    public int getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(int repairHours) {
        this.repairHours = repairHours;
    }
}