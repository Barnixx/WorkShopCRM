package pl.coderslab.model.employee;

import pl.coderslab.model.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

interface EmployeeDao {

    String SAVE_TO_DB = "INSERT INTO employee(name, last_name, address, phone, note, man_hour)VALUES(?,?,?,?,?,?)";
    String UPDATE = "UPDATE employee SET name = ?, last_name = ?, address = ?, phone = ?, note = ?, man_hour = ?  WHERE id = ?";
    String DELETE = "DELETE FROM employee WHERE id = ?";
    String LOAD_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
    String LOAD_ALL_EMPLOYEE = "SELECT * FROM employee";

    default void saveToDB() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Employee) this).getId() == 0) {
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(SAVE_TO_DB, generatedColumns);
                preparedStatement.setString(1, ((Employee) this).getName());
                preparedStatement.setString(2, ((Employee) this).getLast_name());
                preparedStatement.setString(3, ((Employee) this).getAddress());
                preparedStatement.setString(4, ((Employee) this).getPhone());
                preparedStatement.setString(5, ((Employee) this).getNote());
                preparedStatement.setDouble(6, ((Employee) this).getMan_hour());

                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    ((Employee) this).setId(resultSet.getInt(1));
                }
            } else {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(UPDATE);
                preparedStatement.setString(1, ((Employee) this).getName());
                preparedStatement.setString(2, ((Employee) this).getLast_name());
                preparedStatement.setString(3, ((Employee) this).getAddress());
                preparedStatement.setString(4, ((Employee) this).getPhone());
                preparedStatement.setString(5, ((Employee) this).getNote());
                preparedStatement.setDouble(6, ((Employee) this).getMan_hour());
                preparedStatement.setInt(7, ((Employee) this).getId());
                preparedStatement.executeUpdate();
            }
        }
    }

    default void delete() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Employee) this).getId() != 0) {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(DELETE);
                preparedStatement.setInt(1, ((Employee) this).getId());
                preparedStatement.executeUpdate();
                ((Employee) this).setId(0);
            }
        }
    }

    static Employee loadById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(LOAD_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee loadedEmployee = new Employee();
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setLast_name(resultSet.getString("last_name"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("address"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setMan_hour(resultSet.getDouble("man_hour"));

                return loadedEmployee;
            }
            return null;
        }
    }

    static List<Employee> loadAll() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Employee> employeesList = new ArrayList<>();
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(LOAD_ALL_EMPLOYEE);

            while (resultSet.next()) {
                Employee loadedEmployee = new Employee();
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setLast_name(resultSet.getString("last_name"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("address"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setMan_hour(resultSet.getDouble("man_hour"));

                employeesList.add(loadedEmployee);
            }
            return employeesList;
        }
    }
}
