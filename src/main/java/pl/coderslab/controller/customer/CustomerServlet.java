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
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    final String TITLE = "Klienci";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customerList = null;
        try {
            customerList = CustomerDao.loadAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerList != null) {
            request.setAttribute("customerList", customerList);
        }
        request.setAttribute("title", TITLE);
        getServletContext().getRequestDispatcher("/customer/customer.jsp")
                .forward(request, response);

    }

}
