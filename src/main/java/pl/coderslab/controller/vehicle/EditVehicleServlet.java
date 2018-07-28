package pl.coderslab.controller.vehicle;

import pl.coderslab.model.customer.Customer;
import pl.coderslab.model.customer.CustomerDao;
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

@WebServlet(name = "EditVehicleServlet", urlPatterns = "/editVehicle")
public class EditVehicleServlet extends HttpServlet {
    private static final String title = "Edytuj Pojazd";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String yearOfProduction = request.getParameter("yearOfProduction");
            String licensePlate = request.getParameter("licensePlate");
            String nextInspection = request.getParameter("nextInspection");
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));

            Vehicle vehicle = VehicleDao.loadById(id);

            vehicle.setBrand(brand);
            vehicle.setModel(model);
            vehicle.setYear_of_production(yearOfProduction);
            vehicle.setLicense_plate(licensePlate);
            vehicle.setNext_inspection(nextInspection);
            vehicle.setCustomer(CustomerDao.loadById(customer_id));

            vehicle.saveToDB();
            response.sendRedirect("/vehicleDetails?id=" + id);
        } catch (SQLException | NullPointerException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", title);

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Vehicle vehicle = VehicleDao.loadById(id);
            request.setAttribute("vehicle", vehicle);
            List<Customer> customers = CustomerDao.loadAll();
            request.setAttribute("customers", customers);
            getServletContext().getRequestDispatcher("/vehicle/editVehicle.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
