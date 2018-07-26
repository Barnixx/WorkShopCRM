package pl.coderslab.controller.employee;

import pl.coderslab.model.employee.Employee;
import pl.coderslab.model.employee.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    final String TITLE = "Pracownicy";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employeeList = null;
        try {
            employeeList = EmployeeDao.loadAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (employeeList != null) {
            request.setAttribute("employeeList", employeeList);
        }
        request.setAttribute("title", TITLE);
        getServletContext().getRequestDispatcher("/employee/employee.jsp")
                .forward(request, response);

    }
}