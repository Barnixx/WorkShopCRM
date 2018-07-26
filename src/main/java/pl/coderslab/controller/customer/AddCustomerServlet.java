package pl.coderslab.controller.customer;

import pl.coderslab.model.customer.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddCustomerServlet", urlPatterns = "/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("dateOfBirth");
            Customer customer = new Customer(name, lastName, address);
            customer.saveToDB();
            response.sendRedirect("/customer");
        } catch (SQLException | NullPointerException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/customer/addCustomer.jsp")
                .forward(request, response);
    }
}
