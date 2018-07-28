package pl.coderslab.controller.vehicle;

import pl.coderslab.model.customer.Customer;
import pl.coderslab.model.customer.CustomerDao;
import pl.coderslab.model.vehicle.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddVehicleServlet", urlPatterns = "/addVehicle")
public class AddVehicleServlet extends HttpServlet {
    private static final String title = "Dodaj Pojazd";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String yearOfProduction = request.getParameter("yearOfProduction");
            String licensePlate = request.getParameter("licensePlate");
            String nextInspection = request.getParameter("nextInspection");
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            Customer customer = CustomerDao.loadById(customer_id);

            Vehicle vehicle = new Vehicle(model, brand, yearOfProduction, licensePlate, nextInspection, customer);
            vehicle.saveToDB();

            response.sendRedirect("/vehicle");
        } catch (SQLException | NullPointerException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);
        List<Customer> customers = null;
        try {
            customers = CustomerDao.loadAll();
            request.setAttribute("customers", customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/vehicle/addVehicle.jsp")
                .forward(request, response);
    }
}
