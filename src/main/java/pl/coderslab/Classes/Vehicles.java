package pl.coderslab.Classes;

import java.util.Date;

public class Vehicles {

    private String model;
    private String brand;
    private Date productionYear;
    private String registrationNumber;
    private Date nextRepairDate;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Date productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getNextRepairDate() {
        return nextRepairDate;
    }

    public void setNextRepairDate(Date nextRepairDate) {
        this.nextRepairDate = nextRepairDate;
    }
}
