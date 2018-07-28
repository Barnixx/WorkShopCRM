package pl.coderslab.model.vehicle;

import pl.coderslab.model.DbUtil;
import pl.coderslab.model.customer.CustomerDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface VehicleDao {
    String SAVE_TO_DB = "INSERT INTO vehicle(model, brand, year_of_production, license_plate, next_inspection, customer_id)VALUES(?,?,?,?,?,?)";
    String UPDATE = "UPDATE vehicle SET model = ?, brand= ?, year_of_production = ?, license_plate = ?, next_inspection = ?, customer_id = ? WHERE id = ?";
    String DELETE = "DELETE FROM vehicle WHERE id = ?";
    String LOAD_VEHICLE_BY_ID = "SELECT * FROM vehicle WHERE id = ?";
    String LOAD_ALL_VEHICLE = "SELECT * FROM vehicle";
    String LOAD_BY_CUSTOMER = "SELECT * FROM vehicle WHERE customer_id = ?";

    default void saveToDB() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Vehicle) this).getId() == 0) {
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(SAVE_TO_DB, generatedColumns);
                preparedStatement.setString(1, ((Vehicle) this).getModel());
                preparedStatement.setString(2, ((Vehicle) this).getBrand());
                preparedStatement.setString(3, ((Vehicle) this).getYear_of_production());
                preparedStatement.setString(4, ((Vehicle) this).getLicense_plate());
                preparedStatement.setString(5, ((Vehicle) this).getNext_inspection());
                if (((Vehicle) this).getCustomer() != null) {
                    preparedStatement.setInt(6, ((Vehicle) this).getCustomer().getId());
                } else {
                    preparedStatement.setNull(6, java.sql.Types.INTEGER);
                }
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    ((Vehicle) this).setId(resultSet.getInt(1));
                }
            } else {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(UPDATE);
                preparedStatement.setString(1, ((Vehicle) this).getModel());
                preparedStatement.setString(2, ((Vehicle) this).getBrand());
                preparedStatement.setDate(3, Date.valueOf(((Vehicle) this).getYear_of_production()));
                preparedStatement.setString(4, ((Vehicle) this).getLicense_plate());
                preparedStatement.setString(5, ((Vehicle) this).getNext_inspection());
                if (((Vehicle) this).getCustomer() != null) {
                    preparedStatement.setInt(6, ((Vehicle) this).getCustomer().getId());
                } else {
                    preparedStatement.setNull(6, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(7, ((Vehicle) this).getId());
                preparedStatement.executeUpdate();
            }
        }
    }

    default void delete() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Vehicle) this).getId() != 0) {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(DELETE);
                preparedStatement.setInt(1, ((Vehicle) this).getId());
                preparedStatement.executeUpdate();
                ((Vehicle) this).setId(0);
            }
        }
    }

    static Vehicle loadById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(LOAD_VEHICLE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Vehicle loadedVehicle = new Vehicle();
                loadedVehicle.setId(resultSet.getInt("id"));
                loadedVehicle.setModel(resultSet.getString("model"));
                loadedVehicle.setBrand(resultSet.getString("brand"));
                loadedVehicle.setYear_of_production(resultSet.getString("year_of_production"));
                loadedVehicle.setLicense_plate(resultSet.getString("license_plate"));
                loadedVehicle.setNext_inspection(String.valueOf(resultSet.getDate("next_inspection")));
                loadedVehicle.setCustomer(CustomerDao.loadById(resultSet.getInt("customer_id")));

                return loadedVehicle;
            }
            return null;
        }
    }

    static List<Vehicle> loadAll() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Vehicle> vehiclesList = new ArrayList<>();
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(LOAD_ALL_VEHICLE);

            while (resultSet.next()) {
                Vehicle loadedVehicle = new Vehicle();
                loadedVehicle.setId(resultSet.getInt("id"));
                loadedVehicle.setModel(resultSet.getString("model"));
                loadedVehicle.setBrand(resultSet.getString("brand"));
                loadedVehicle.setYear_of_production(resultSet.getString("year_of_production"));
                loadedVehicle.setLicense_plate(resultSet.getString("license_plate"));
                loadedVehicle.setNext_inspection(String.valueOf(resultSet.getDate("next_inspection")));
                loadedVehicle.setCustomer(CustomerDao.loadById(resultSet.getInt("customer_id")));

                vehiclesList.add(loadedVehicle);
            }
            return vehiclesList;
        }
    }

    static List<Vehicle> loadByCustomer(int customerId) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Vehicle> vehiclesList = new ArrayList<>();
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(LOAD_BY_CUSTOMER);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vehicle loadedVehicle = new Vehicle();
                loadedVehicle.setId(resultSet.getInt("id"));
                loadedVehicle.setModel(resultSet.getString("model"));
                loadedVehicle.setBrand(resultSet.getString("brand"));
                loadedVehicle.setYear_of_production(resultSet.getString("year_of_production"));
                loadedVehicle.setLicense_plate(resultSet.getString("license_plate"));
                loadedVehicle.setNext_inspection(String.valueOf(resultSet.getDate("next_inspection")));
                loadedVehicle.setCustomer(CustomerDao.loadById(resultSet.getInt("customer_id")));

                vehiclesList.add(loadedVehicle);
            }
            return vehiclesList;
        }
    }

}
