package pl.coderslab;

import pl.coderslab.model.customer.Customer;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {


        try {
            Customer customer = new Customer("Andrzej", "Skoczek", "1990-02-18");
            customer.saveToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
