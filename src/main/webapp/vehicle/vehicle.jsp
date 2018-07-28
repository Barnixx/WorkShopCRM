<%--
  Created by IntelliJ IDEA.
  User: barni
  Date: 27.07.18
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item active">Pojazdy</li>
    </ol>
    <h1>Pojazdy</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Marka</th>
            <th scope="col">Model</th>
            <th scope="col">Data Produkcji</th>
            <th scope="col">Nr Rejestracyjny</th>
            <th scope="col">Następny przegląd</th>
            <th scope="col">Właściciel</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehicles}" var="vehicle">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.brand}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.year_of_production}</td>
                <td>${vehicle.license_plate}</td>
                <td>${vehicle.next_inspection}</td>
                <td>${vehicle.customer.name} ${vehicle.customer.last_name}</td>
                <td><a href="/vehicleDetails?id=${vehicle.id}" class="btn btn-info" role="button">Szczegóły</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../WEB-INF/footer.jsp" %>