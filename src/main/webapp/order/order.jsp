<%--
  Created by IntelliJ IDEA.
  User: barni
  Date: 27.07.18
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item active">Zlecenia</li>
    </ol>
    <h1>Zlecenia</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Data Akceptacji</th>
            <th scope="col">Planowany czas startu</th>
            <th scope="col">Czas zakończenia</th>
            <th scope="col">Status</th>
            <th scope="col">Koszt naprawy</th>
            <th scope="col">Wykonał naprawe</th>
            <th scope="col">Klient</th>
            <th scope="col">Pojazd</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.date_of_accepting}</td>
                <td>${order.planned_start_date}</td>
                <td>${order.end_date eq 'null' ? "brak" : order.end_date}</td>
                <td>${order.status}</td>
                <td>${order.repair_cost} PLN</td>
                <td>${order.employee.name} ${order.employee.last_name}</td>
                <td>${order.customer.name} ${order.customer.last_name}</td>
                <td>${order.vehicle.license_plate}</td>
                <td>
                    <a href="/orderDetails?id=${order.id}" class="btn btn-info" role="button">Sczegóły</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../WEB-INF/footer.jsp" %>
