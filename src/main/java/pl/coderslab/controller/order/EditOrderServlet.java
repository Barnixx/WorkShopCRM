package pl.coderslab.controller.order;

import pl.coderslab.model.customer.Customer;
import pl.coderslab.model.customer.CustomerDao;
import pl.coderslab.model.employee.Employee;
import pl.coderslab.model.employee.EmployeeDao;
import pl.coderslab.model.order.Order;
import pl.coderslab.model.order.OrderDao;
import pl.coderslab.model.vehicle.Vehicle;
import pl.coderslab.model.vehicle.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditOrderServlet", urlPatterns = "/addOrder")
public class EditOrderServlet extends HttpServlet {
    private static final String title = "Edytuj Zlecenie";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String dateOfAccepting = request.getParameter("dateOfAccepting");
        String plannedStartDate = request.getParameter("plannedStartDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String descriptionOfTheProblem = request.getParameter("descriptionOfTheProblem");
        String repairDescription = request.getParameter("repairDescription");
        String repairCost = request.getParameter("repairCost");
        String partCost = request.getParameter("partCost");
        String manHours = request.getParameter("manHours");
        String employee = request.getParameter("employee_id");
        String customer = request.getParameter("customer_id");
        String vehicle = request.getParameter("vehicle_id");
        Order order = new Order();
        try {
            if (id != null) {
                order = OrderDao.loadById(Integer.parseInt(id));
            }
            order.setDate_of_accepting(dateOfAccepting);
            order.setPlanned_start_date(plannedStartDate);
            order.setEnd_date(endDate);
            order.setStatus(status);
            order.setDescription_of_the_problem(descriptionOfTheProblem);
            order.setRepair_description(repairDescription);

            order.setRepair_cost(repairCost.equals("") ? 0 : Double.parseDouble(repairCost));
            order.setPart_cost(partCost.equals("") ? 0 : Double.parseDouble(partCost));
            order.setMan_hours(manHours.equals("") ? 0 : Integer.parseInt(manHours));
            order.setEmployee(EmployeeDao.loadById(Integer.parseInt(employee)));
            order.setCustomer(CustomerDao.loadById(Integer.parseInt(customer)));
            order.setVehicle(VehicleDao.loadById(Integer.parseInt(vehicle)));

            order.saveToDB();
            response.sendRedirect("/orderDetails?id=" + (id == null ? order.getId() : id));
        } catch (SQLException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);
        String id = request.getParameter("id");

        try {
            if (id != null) {
                Order order = OrderDao.loadById(Integer.parseInt(id));
                request.setAttribute("order", order);
            }

            List<Vehicle> vehicles = VehicleDao.loadAll();
            request.setAttribute("vehicles", vehicles);

            List<Customer> customers = CustomerDao.loadAll();
            request.setAttribute("customers", customers);

            List<Employee> employees = EmployeeDao.loadAll();
            request.setAttribute("employees", employees);

        } catch (SQLException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/order/editOrder.jsp")
                .forward(request, response);
    }
}
