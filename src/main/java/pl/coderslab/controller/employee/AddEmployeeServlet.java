package pl.coderslab.controller.employee;

import pl.coderslab.model.employee.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddEmployeeServlet", urlPatterns = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private static final String title = "Dodaj Pracownika";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String note = request.getParameter("note");
            double manHour = Double.parseDouble(request.getParameter("manHour"));
            Employee employee = new Employee(name, lastName, address, phone, note, manHour);
            employee.saveToDB();
            response.sendRedirect("/employee");
        } catch (SQLException | NullPointerException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", title);
        getServletContext().getRequestDispatcher("/employee/addEmployee.jsp")
                .forward(request, response);
    }
}
