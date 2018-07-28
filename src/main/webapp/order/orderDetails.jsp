<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div class="content">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/order">Zlecenia</a></li>
        <li class="breadcrumb-item active">Zlecenie NR ${order.id}</li>
    </ol>
    <h1 align="center">Zlecenie NR ${order.id}</h1><br>
    <div class="container">
        <div class="row">
            <div class="col-md-6" style="background: beige">
                <h2><i>Zlecenie</i></h2>
                <h4>Data Akceptacji</h4>
                <p>${order.date_of_accepting}</p>
                <h5>Planowana data rozpoczęcia naprawy</h5>
                <p>${order.planned_start_date}</p>
                <h5>Data zakończenia</h5>
                <p>${order.end_date}</p>
                <h5>Opis problemu</h5>
                <p>${order.description_of_the_problem}</p>
                <h5>Opis naprawy</h5>
                <p>${order.repair_description}</p>
                <h5>Status</h5>
                <p>${order.status}</p>
                <h5>Koszt naprawy</h5>
                <p>${order.repair_cost} PLN</p>
                <h5>Koszt części</h5>
                <p>${order.part_cost} PLN</p>
                <h5>Roboczogodziny</h5>
                <p>${order.man_hours}</p>
                <h5>Koszt robocizny</h5>
                <p>${order.man_hours * order.employee.man_hour} PLN</p>
            </div>
            <div class="col-md-6">
                <h2>Pracownik</h2>
                <h5>Nr Pracownika</h5>
                <p>${order.employee.id}</p>
                <h5>Imie i nazwisko</h5>
                <p>${order.employee.name} ${order.employee.last_name}</p>
                <h5>Adres</h5>
                <p>${order.employee.address}</p>
                <h5>Telefon</h5>
                <p>${order.employee.phone}</p>
                <h5>Notatka</h5>
                <p>${order.employee.note}</p>
                <h5>Stawka</h5>
                <p>${order.employee.man_hour}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <h2>Klient</h2>
                <h5>Nr Klienta</h5>
                <p>${order.customer.id}</p>
                <h5>Imie i nazwisko</h5>
                <p>${order.customer.name} ${order.customer.last_name}</p><br>

            </div>
            <div class="col-md-6" style="background: beige">
                <h2>Pojazd</h2>
                <h5>Nr Pojazdu</h5>
                <p>${order.vehicle.id}</p>
                <h5>Marka i Model</h5>
                <p>${order.vehicle.brand} ${order.vehicle.model}</p>
                <h5>Data produkcji</h5>
                <p>${order.vehicle.year_of_production}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" align="center">
                <a href="/addOrder?id=${order.id}" class="btn btn-warning" role="button">Edytuj</a>
                <a href="/deleteOrder?id=${order.id}" class="btn btn-danger" role="button">Usuń</a>
            </div>
        </div>
    </div>
</div>
<%@include file="../WEB-INF/footer.jsp" %>