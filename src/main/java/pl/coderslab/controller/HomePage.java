package pl.coderslab.controller;

import pl.coderslab.model.order.Order;
import pl.coderslab.model.order.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "HomePage", urlPatterns = "/")
public class HomePage extends HttpServlet {
    final String TITLE = "Strona główna";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> currentOrder = null;
        try {
            currentOrder = OrderDao.loadAll();
            currentOrder = currentOrder.stream()
                    .filter(order -> !(order.getStatus().equals("Gotowy do odbioru") || (order.getStatus().equals("Rezygnacja"))))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (currentOrder != null) {
            request.setAttribute("currentOrder", currentOrder);
        }
        request.setAttribute("title", TITLE);
        getServletContext().getRequestDispatcher("/home.jsp")
                .forward(request, response);

    }
}
