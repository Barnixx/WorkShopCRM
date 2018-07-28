package pl.coderslab.controller.employee;

import pl.coderslab.model.employee.Employee;
import pl.coderslab.model.employee.EmployeeDao;
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
import java.util.stream.Collectors;

@WebServlet(name = "EmployeeDetailsServlet", urlPatterns = "/employeeDetails")
public class EmployeeDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = EmployeeDao.loadById(id);
            request.setAttribute("employee", employee);
            List<Order> orders = OrderDao.loadByEmployee(id);
            orders = orders.stream()
                    .filter(order -> order.getStatus().equals("W naprawie"))
                    .collect(Collectors.toList());
            request.setAttribute("orders", orders);
            getServletContext().getRequestDispatcher("/employee/employeeDetails.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
