<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 26.07.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <h1>Trwające naprawy</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Data Akceptacji</th>
            <th scope="col">Planowany czas startu</th>
            <th scope="col">Czas zakończenia</th>
            <th scope="col">Status</th>
            <th scope="col">Koszt naprawy</th>
            <th scope="col">Koszt części</th>
            <th scope="col">Godziny pracy</th>
            <th scope="col">Koszt roboczogodzin</th>
            <th scope="col">Wykonał naprawe</th>
            <th scope="col">Klient</th>
            <th scope="col">Pojazd</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${currentOrder}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.date_of_accepting}</td>
                <td>${order.planned_start_date}</td>
                <td>${order.end_date}</td>
                <td>${order.status}</td>
                <td>${order.repair_cost} PLN</td>
                <td>${order.part_cost} PLN</td>
                <td>${order.man_hours}</td>
                <td>${order.man_hours * order.employee.man_hour} PLN</td>
                <td>${order.employee.name} ${order.employee.last_name}</td>
                <td>${order.customer.name} ${order.customer.last_name}</td>
                <td>${order.vehicle.license_plate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>