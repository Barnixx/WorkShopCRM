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

@WebServlet(name = "DeleteOrderServlet", urlPatterns = "/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            try {
                Order vehicle = OrderDao.loadById(Integer.parseInt(id));
                vehicle.delete();
                response.sendRedirect("/order");
            } catch (SQLException | NumberFormatException | NullPointerException e) {
                response.getWriter().append("Coś poszło nie tak");
                e.printStackTrace();
            }
        }
    }
}
