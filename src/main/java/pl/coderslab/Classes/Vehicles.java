package pl.coderslab.Classes;

import java.sql.Date;

public class Vehicles {
    private int id;
    private String model;
    private String brand;
    private Date productionYear;
    private String registrationNumber;
    private Date nextRepairDate;
    private int client_id;


    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Vehicles(String model, String brand, Date productionYear, String registrationNumber, Date nextRepairDate, int client_id) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.nextRepairDate = nextRepairDate;
        this.client_id = client_id;
    }

    public Vehicles() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



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
