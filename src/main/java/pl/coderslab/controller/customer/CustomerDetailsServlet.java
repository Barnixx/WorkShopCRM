package pl.coderslab.controller.customer;

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

@WebServlet(name = "CustomerDetailsServlet", urlPatterns = "/customerDetails")
public class CustomerDetailsServlet extends HttpServlet {
    private static final String title = "Szczegóły Klienta";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = CustomerDao.loadById(id);
            request.setAttribute("customer", customer);
            List<Vehicle> vehicles = VehicleDao.loadByCustomer(id);
            request.setAttribute("vehicles", vehicles);
            getServletContext().getRequestDispatcher("/customer/customerDetails.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
