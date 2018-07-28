package pl.coderslab.controller.order;

import pl.coderslab.model.order.Order;
import pl.coderslab.model.order.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderDetalisServlet", urlPatterns = "/orderDetails")
public class OrderDetalisServlet extends HttpServlet {
    private static final String title = "Szegóły zlecenia";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", title);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Order order = OrderDao.loadById(id);
            request.setAttribute("order", order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/order/orderDetails.jsp")
                .forward(request, response);
    }
}
