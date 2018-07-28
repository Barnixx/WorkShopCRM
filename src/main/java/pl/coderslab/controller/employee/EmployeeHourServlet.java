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

@WebServlet(name = "EmployeeHourServlet", urlPatterns = "/employeeRaport")
public class EmployeeHourServlet extends HttpServlet {
    private static final String title = "Rapoty pracowników";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", title);

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        try {
            List<Employee> employees = EmployeeDao.hourRaport(startDate, endDate);
            request.setAttribute("employees", employees);
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/employee/employeeRaport.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);
        getServletContext().getRequestDispatcher("/employee/employeeRaport.jsp")
                .forward(request, response);
    }
}
