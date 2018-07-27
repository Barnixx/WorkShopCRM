package pl.coderslab.controller.customer;

import pl.coderslab.model.vehicle.Vehicle;
import pl.coderslab.model.vehicle.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerVehicleServlet", urlPatterns = "/customerVehicle")
public class CustomerVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Vehicle> customerVehicles = VehicleDao.loadByCustomer(id);
            request.setAttribute("vehicles", customerVehicles);
            getServletContext().getRequestDispatcher("/vehicle/vehicle.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
