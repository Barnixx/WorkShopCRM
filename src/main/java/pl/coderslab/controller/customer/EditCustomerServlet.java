package pl.coderslab.controller.customer;


import pl.coderslab.model.customer.Customer;
import pl.coderslab.model.customer.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditCustomerServlet", urlPatterns = "/editCustomer")
public class EditCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String dateOfBirth = request.getParameter("dateOfBirth");

            Customer employee = CustomerDao.loadById(id);

            employee.setName(name);
            employee.setLast_name(lastName);
            employee.setDate_of_birth(dateOfBirth);

            employee.saveToDB();
            response.sendRedirect("/customer");
        } catch (SQLException | NullPointerException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            try {
                Customer customer = CustomerDao.loadById(Integer.parseInt(id));
                request.setAttribute("customer", customer);
                getServletContext().getRequestDispatcher("/customer/editCustomer.jsp")
                        .forward(request, response);
            } catch (SQLException | NumberFormatException e) {
                response.getWriter().append("Coś poszło nie tak...");
                e.printStackTrace();
            }
        }
    }
}
