package pl.coderslab.model.order;

import pl.coderslab.model.customer.Customer;
import pl.coderslab.model.employee.Employee;
import pl.coderslab.model.vehicle.Vehicle;

public class Order implements OrderDao {
    private int id;
    private String date_of_accepting;
    private String planned_start_date;
    private String end_date;
    private String description_of_the_problem;
    private String repair_description;
    private String status;
    private double repair_cost;
    private double part_cost;
    private int man_hours;
    private Vehicle vehicle;
    private Customer customer;
    private Employee employee;

    public Order() {
    }

    public Order(String date_of_accepting, String planned_start_date, String end_date, String description_of_the_problem, String repair_description, String status, double repair_cost, double part_cost, int man_hours, Vehicle vehicle, Customer customer, Employee employee) {
        this.date_of_accepting = date_of_accepting;
        this.planned_start_date = planned_start_date;
        this.end_date = end_date;
        this.description_of_the_problem = description_of_the_problem;
        this.repair_description = repair_description;
        this.status = status;
        this.repair_cost = repair_cost;
        this.part_cost = part_cost;
        this.man_hours = man_hours;
        this.vehicle = vehicle;
        this.customer = customer;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_of_accepting() {
        return date_of_accepting;
    }

    public void setDate_of_accepting(String date_of_accepting) {
        this.date_of_accepting = date_of_accepting;
    }

    public String getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(String planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDescription_of_the_problem() {
        return description_of_the_problem;
    }

    public void setDescription_of_the_problem(String description_of_the_problem) {
        this.description_of_the_problem = description_of_the_problem;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(double repair_cost) {
        this.repair_cost = repair_cost;
    }

    public double getPart_cost() {
        return part_cost;
    }

    public void setPart_cost(double part_cost) {
        this.part_cost = part_cost;
    }

    public int getMan_hours() {
        return man_hours;
    }

    public void setMan_hours(int man_hours) {
        this.man_hours = man_hours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
