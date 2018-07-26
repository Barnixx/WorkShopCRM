package pl.coderslab.model.customer;

import pl.coderslab.model.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDao {
    String SAVE_TO_DB = "INSERT INTO customer(`name`,`last_name`,`date_of_birth`)VALUES(?,?,?)";
    String UPDATE = "UPDATE customer SET name = ?, last_name = ?, date_of_birth = ? WHERE id = ?";
    String DELETE = "DELETE FROM customer WHERE id = ?";
    String LOAD_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id = ?";
    String LOAD_ALL_CUSTOMER = "SELECT * FROM customer";

    default void saveToDB() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Customer) this).getId() == 0) {
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(SAVE_TO_DB, generatedColumns);
                preparedStatement.setString(1, ((Customer) this).getName());
                preparedStatement.setString(2, ((Customer) this).getLast_name());
                preparedStatement.setDate(3, Date.valueOf(((Customer) this).getDate_of_birth()));

                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    ((Customer) this).setId(resultSet.getInt(1));
                }
            } else {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(UPDATE);
                preparedStatement.setString(1, ((Customer) this).getName());
                preparedStatement.setString(2, ((Customer) this).getLast_name());
                preparedStatement.setDate(3, Date.valueOf(((Customer) this).getDate_of_birth()));
                preparedStatement.setInt(4, ((Customer) this).getId());
                preparedStatement.executeUpdate();
            }
        }
    }

    default void delete() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Customer) this).getId() != 0) {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(DELETE);
                preparedStatement.setInt(1, ((Customer) this).getId());
                preparedStatement.executeUpdate();
                ((Customer) this).setId(0);
            }
        }
    }

    static Customer loadById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(LOAD_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer loadedCustomer = new Customer();
                loadedCustomer.setId(resultSet.getInt("id"));
                loadedCustomer.setName(resultSet.getString("name"));
                loadedCustomer.setLast_name(resultSet.getString("last_name"));
                loadedCustomer.setDate_of_birth(String.valueOf(resultSet.getDate("date_of_birth")));

                return loadedCustomer;
            }
            return null;
        }
    }

    static List<Customer> loadAll() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Customer> customersList = new ArrayList<>();
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(LOAD_ALL_CUSTOMER);

            while (resultSet.next()) {
                Customer loadedCustomer = new Customer();
                loadedCustomer.setId(resultSet.getInt("id"));
                loadedCustomer.setName(resultSet.getString("name"));
                loadedCustomer.setLast_name(resultSet.getString("last_name"));
                loadedCustomer.setDate_of_birth(String.valueOf(resultSet.getDate("date_of_birth")));

                customersList.add(loadedCustomer);
            }
            return customersList;
        }
    }
}
