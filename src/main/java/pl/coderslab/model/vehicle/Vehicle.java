package pl.coderslab.model.vehicle;

import pl.coderslab.model.customer.Customer;

public class Vehicle implements VehicleDao {
    private int id;
    private String model;
    private String brand;
    private String year_of_production;
    private String license_plate;
    private String next_inspection;
    private Customer customer;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String year_of_production, String license_plate, String next_inspection, Customer customer) {
        this.model = model;
        this.brand = brand;
        this.year_of_production = year_of_production;
        this.license_plate = license_plate;
        this.next_inspection = next_inspection;
        this.customer = customer;
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

    public String getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(String year_of_production) {
        this.year_of_production = year_of_production;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getNext_inspection() {
        return next_inspection;
    }

    public void setNext_inspection(String next_inspection) {
        this.next_inspection = next_inspection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year_of_production='" + year_of_production + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", next_inspection='" + next_inspection + '\'' +
                '}';
    }
}
