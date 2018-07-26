package pl.coderslab.model.order;

import pl.coderslab.model.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    String SAVE_TO_DB = "INSERT INTO `order`(date_of_accepting, planned_start_date, end_date, description_of_the_problem, repair_description, status, repair_cost, part_cost, man_hours, vehicle_id, customer_id, employee_id) VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE = "UPDATE `order` SET date_of_accepting = ?, planned_start_date = ?, end_date = ?, description_of_the_problem = ?, repair_description = ?, status = ?, repair_cost = ?, part_cost = ?, man_hours = ?, vehicle_id = ?, customer_id = ?, employee_id = ?  WHERE id = ?";
    String DELETE = "DELETE FROM `order` WHERE id = ?";
    String LOAD_ORDER_BY_ID = "SELECT * FROM `order` WHERE id = ?";
    String LOAD_ALL_ORDER = "SELECT * FROM `order`";
    String LOAD_CURRENT_ORDER = "SELECT * FROM order WHERE status NOT LIKE 'Gotowy do odbioru' AND status NOT LIKE 'Rezygnacja'";

    default void saveToDB() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Order) this).getId() == 0) {
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(SAVE_TO_DB, generatedColumns);
                preparedStatement.setDate(1, Date.valueOf(((Order) this).getDate_of_accepting()));
                preparedStatement.setDate(2, Date.valueOf(((Order) this).getPlanned_start_date()));
                preparedStatement.setDate(3, Date.valueOf(((Order) this).getEnd_date()));
                preparedStatement.setString(4, ((Order) this).getDescription_of_the_problem());
                preparedStatement.setString(5, ((Order) this).getRepair_description());
                preparedStatement.setString(6, ((Order) this).getStatus());
                preparedStatement.setDouble(7, ((Order) this).getRepair_cost());
                preparedStatement.setDouble(8, ((Order) this).getPart_cost());
                preparedStatement.setInt(9, ((Order) this).getMan_hours());
                preparedStatement.setInt(10, ((Order) this).getVehicle_id());
                preparedStatement.setInt(11, ((Order) this).getCustomer_id());
                preparedStatement.setInt(12, ((Order) this).getEmployee_id());

                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    ((Order) this).setId(resultSet.getInt(1));
                }
            } else {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(UPDATE);
                preparedStatement.setDate(1, Date.valueOf(((Order) this).getDate_of_accepting()));
                preparedStatement.setDate(2, Date.valueOf(((Order) this).getPlanned_start_date()));
                preparedStatement.setDate(3, Date.valueOf(((Order) this).getEnd_date()));
                preparedStatement.setString(4, ((Order) this).getDescription_of_the_problem());
                preparedStatement.setString(5, ((Order) this).getRepair_description());
                preparedStatement.setString(6, ((Order) this).getStatus());
                preparedStatement.setDouble(7, ((Order) this).getRepair_cost());
                preparedStatement.setDouble(8, ((Order) this).getPart_cost());
                preparedStatement.setInt(9, ((Order) this).getMan_hours());
                preparedStatement.setInt(10, ((Order) this).getVehicle_id());
                preparedStatement.setInt(11, ((Order) this).getCustomer_id());
                preparedStatement.setInt(12, ((Order) this).getEmployee_id());
                preparedStatement.setInt(13, ((Order) this).getId());
                preparedStatement.executeUpdate();
            }
        }
    }

    default void delete() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (((Order) this).getId() != 0) {
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(DELETE);
                preparedStatement.setInt(1, ((Order) this).getId());
                preparedStatement.executeUpdate();
                ((Order) this).setId(0);
            }
        }
    }

    static Order loadById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(LOAD_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order loadedOrder = new Order();
                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setDate_of_accepting(String.valueOf(resultSet.getDate("date_of_accepting")));
                loadedOrder.setPlanned_start_date(String.valueOf(resultSet.getDate("planned_start_date")));
                loadedOrder.setEnd_date(String.valueOf(resultSet.getDate("end_date")));
                loadedOrder.setDescription_of_the_problem(resultSet.getString("description_of_the_problem"));
                loadedOrder.setRepair_description(resultSet.getString("repair_description"));
                loadedOrder.setStatus(resultSet.getString("status"));
                loadedOrder.setRepair_cost(resultSet.getDouble("repair_cost"));
                loadedOrder.setPart_cost(resultSet.getDouble("part_cost"));
                loadedOrder.setMan_hours(resultSet.getInt("man_hours"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setCustomer_id(resultSet.getInt("customer_id"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));

                return loadedOrder;
            }
            return null;
        }
    }


    static List<Order> loadAll() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Order> ordersList = new ArrayList<>();
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(LOAD_ALL_ORDER);

            while (resultSet.next()) {
                Order loadedOrder = new Order();
                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setDate_of_accepting(String.valueOf(resultSet.getDate("date_of_accepting")));
                loadedOrder.setPlanned_start_date(String.valueOf(resultSet.getDate("planned_start_date")));
                loadedOrder.setEnd_date(String.valueOf(resultSet.getDate("end_date")));
                loadedOrder.setDescription_of_the_problem(resultSet.getString("description_of_the_problem"));
                loadedOrder.setRepair_description(resultSet.getString("repair_description"));
                loadedOrder.setStatus(resultSet.getString("status"));
                loadedOrder.setRepair_cost(resultSet.getDouble("repair_cost"));
                loadedOrder.setPart_cost(resultSet.getDouble("part_cost"));
                loadedOrder.setMan_hours(resultSet.getInt("man_hours"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setCustomer_id(resultSet.getInt("customer_id"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));

                ordersList.add(loadedOrder);
            }
            return ordersList;
        }
    }

}
