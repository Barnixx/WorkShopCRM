<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div class="content">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/employee">Pracownicy</a></li>
        <li class="breadcrumb-item active">Pracownik NR ${employee.id}</li>
    </ol>
    <h1>Pracownik NR ${employee.id}</h1><br>
    <div>
        <h4>Imie i nazwisko</h4>
        <p>${employee.name} ${employee.last_name}</p>
        <h5>Adres</h5>
        <p>${employee.address}</p>
        <h5>Telefon</h5>
        <p>${employee.phone}</p>
        <h5>Stawka</h5>
        <p>${employee.man_hour} PLN/h</p>
        <h5>Notatka</h5>
        <p>${employee.note}</p>

        <a href="/editEmployee?id=${employee.id}" class="btn btn-warning" role="button">Edytuj</a>
        <a href="/deleteEmployee?id=${employee.id}" class="btn btn-danger" role="button">Usuń</a>
    </div>


    <div>
        <h1>Zlecenia Pracownika</h1>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Data Akceptacji</th>
                <th scope="col">Planowany czas startu</th>
                <th scope="col">Czas zakończenia</th>
                <th scope="col">Status</th>
                <th scope="col">Koszt naprawy</th>
                <th scope="col">Godziny pracy</th>
                <th scope="col">Koszt roboczogodzin</th>
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
                    <td>${order.end_date}</td>
                    <td>${order.status}</td>
                    <td>${order.repair_cost} PLN</td>
                    <td>${order.man_hours}</td>
                    <td>${order.man_hours * order.employee.man_hour} PLN</td>
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
</div>
<%@include file="../WEB-INF/footer.jsp" %>