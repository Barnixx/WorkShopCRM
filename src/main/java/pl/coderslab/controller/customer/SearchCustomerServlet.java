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

@WebServlet(name = "SearchCustomerServlet", urlPatterns = "/searchCustomer")
public class SearchCustomerServlet extends HttpServlet {
    private static final String title = "Szczegóły Klienta";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);

        try {
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            Customer customer = CustomerDao.loadByNameAndLastName(name, lastName);
            if (customer == null) {
                request.setAttribute("warning", "Brak wyników");
                response.sendRedirect("/customer?warning=true");
            } else {
                request.setAttribute("customer", customer);
                List<Vehicle> vehicles = VehicleDao.loadByCustomer(customer.getId());
                request.setAttribute("vehicles", vehicles);
                getServletContext().getRequestDispatcher("/customer/customerDetails.jsp")
                        .forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
