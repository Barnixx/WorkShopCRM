package pl.coderslab.controller.vehicle;

import pl.coderslab.model.order.Order;
import pl.coderslab.model.order.OrderDao;
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

@WebServlet(name = "VehicleDetailsServlet", urlPatterns = "/vehicleDetails")
public class VehicleDetailsServlet extends HttpServlet {
    private static final String title = "Szczegóły pojazdu";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", title);

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Vehicle vehicle = VehicleDao.loadById(id);
            request.setAttribute("vehicle", vehicle);
            List<Order> orders = OrderDao.loadByVehcile(id);
            request.setAttribute("orders", orders);
            getServletContext().getRequestDispatcher("/vehicle/vehicleDetails.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
