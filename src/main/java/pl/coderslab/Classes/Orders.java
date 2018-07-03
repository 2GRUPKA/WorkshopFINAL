package pl.coderslab.Classes;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {

    private int id;
    private Date acceptanceDate;
    private Date planningStartDate;
    private Date startReapir;
    private int employee_id;
    private String problemDescription;
    private String repairDescription;
    private String status;
    private int vehicle_id;
    private BigDecimal repairCost;
    private BigDecimal partCost;
    private int repairHours;

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

    public Date getStartReapir() {
        return startReapir;
    }

    public void setStartReapir(Date startReapir) {
        this.startReapir = startReapir;
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
