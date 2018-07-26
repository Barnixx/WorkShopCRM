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

@WebServlet(name = "DeleteCustomerServlet", urlPatterns = "/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            try {
                Customer customer = CustomerDao.loadById(Integer.parseInt(id));
                customer.delete();
                response.sendRedirect("/customer");
            } catch (SQLException | NumberFormatException | NullPointerException e) {
                response.getWriter().append("Coś poszło nie tak");
                e.printStackTrace();
            }
        }

    }
}
