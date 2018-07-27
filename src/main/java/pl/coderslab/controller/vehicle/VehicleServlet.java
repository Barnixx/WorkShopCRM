package pl.coderslab.controller.vehicle;

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

@WebServlet(name = "VehicleServlet", urlPatterns = "/vehicle")
public class VehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Vehicle> vehicleList = VehicleDao.loadAll();
            request.setAttribute("vehicles", vehicleList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/vehicle/vehicle.jsp")
                .forward(request, response);
    }
}
