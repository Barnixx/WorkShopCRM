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

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = "/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            try {
                Employee employee = EmployeeDao.loadById(Integer.parseInt(id));
                employee.delete();
                response.sendRedirect("/employee");
            } catch (SQLException | NumberFormatException | NullPointerException e) {
                response.getWriter().append("Coś poszło nie tak");
                e.printStackTrace();
            }
        }



    }
}
