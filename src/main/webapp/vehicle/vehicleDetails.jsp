<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div class="content">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/vehicle">Pojazdy</a></li>
        <li class="breadcrumb-item active">Pojazd NR ${vehicle.id}</li>
    </ol>
    <h1>Pojazd NR ${vehicle.id}</h1><br>
    <div>
        <h4>Marka</h4>
        <p>${vehicle.brand}</p>
        <h5>Model</h5>
        <p>${vehicle.model}</p>
        <h5>Rok produckcji</h5>
        <p>${vehicle.year_of_production}</p>
        <h5>Numer Rejestracyjny</h5>
        <p>${vehicle.license_plate}</p>
        <h5>Następny przegląd</h5>
        <p>${vehicle.next_inspection}</p>
        <h5>Właściciel</h5>
        <p>${vehicle.customer.name} ${vehicle.customer.last_name}</p>

        <a href="/editVehicle?id=${vehicle.id}" class="btn btn-warning" role="button">Edytuj</a>
        <a href="/deleteVehicle?id=${vehicle.id}" class="btn btn-danger" role="button">Usuń</a>
    </div>

    <h1>Zlecenia</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Data Akceptacji</th>
            <th scope="col">Planowany czas startu</th>
            <th scope="col">Czas zakończenia</th>
            <th scope="col">Status</th>
            <th scope="col">Opis naprawy</th>
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
                <td>${order.repair_description}</td>
                <td>
                    <a href="/orderDetails?id=${order.id}" class="btn btn-info" role="button">Sczegóły</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../WEB-INF/footer.jsp" %>

