package pl.coderslab.controller.employee;

import pl.coderslab.model.order.Order;
import pl.coderslab.model.order.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeOrdersServlet", urlPatterns = "/employeeOrders")
public class EmployeeOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Order> epmployeeOrder = OrderDao.loadByEmployee(id);
            request.setAttribute("orders", epmployeeOrder);
            getServletContext().getRequestDispatcher("/order/order.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
