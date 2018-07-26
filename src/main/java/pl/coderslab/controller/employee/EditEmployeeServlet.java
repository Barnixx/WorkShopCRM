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

@WebServlet(name = "EditEmployeeServlet", urlPatterns = "/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String note = request.getParameter("note");
            double manHour = Double.parseDouble(request.getParameter("manHour"));

            Employee employee = EmployeeDao.loadById(id);

            employee.setName(name);
            employee.setLast_name(lastName);
            employee.setAddress(address);
            employee.setPhone(phone);
            employee.setMan_hour((manHour));
            employee.setNote(note);

            employee.saveToDB();
            response.sendRedirect("/employee");
        } catch (SQLException | NullPointerException | NumberFormatException e) {
            response.getWriter().append("Coś poszło nie tak...");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            try {
                Employee employee = EmployeeDao.loadById(Integer.parseInt(id));
                request.setAttribute("employee", employee);
                getServletContext().getRequestDispatcher("/employee/editEmployee.jsp")
                        .forward(request, response);
            } catch (SQLException | NumberFormatException e) {
                response.getWriter().append("Coś poszło nie tak...");
                e.printStackTrace();
            }
        }
    }
}
