<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div class="content">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/customer">Klienci</a></li>
        <li class="breadcrumb-item active">Klient nr ${customer.id}</li>
    </ol>
    <h1>Klient NR ${customer.id}</h1><br>
    <div>
        <h4>Imie i nazwisko</h4>
        <p>${customer.name} ${customer.last_name}</p>
        <h5>Telefon</h5>
        <p>${customer.date_of_birth}</p>

        <a href="/editCustomer?id=${customer.id}" class="btn btn-warning" role="button">Edytuj</a>
        <a href="/deleteCustomer?id=${customer.id}" class="btn btn-danger" role="button">Usuń</a>
    </div>


    <div>
        <h1>Pojazdy Klienta</h1>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Marka</th>
                <th scope="col">Model</th>
                <th scope="col">Data Produkcji</th>
                <th scope="col">Nr Rejestracyjny</th>
                <th scope="col">Następny przegląd</th>
                <th></th>
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
                    <td><a href="/vehicleDetails?id=${vehicle.id}" class="btn btn-info" role="button">Szczegóły</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
