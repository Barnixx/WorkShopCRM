<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 26.07.2018
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/employee">Pracownicy</a></li>
        <li class="breadcrumb-item active">Edytuj Pracownika</li>
    </ol>
    <form method="post">
        <div class="form-row">
            <input type="number" name="id" value="${employee.id}" hidden>
            <div class="col">
                <div class="form-group">
                    <label for="name">Imie</label>
                    <input type="text"
                           name="name" id="name" class="form-control" placeholder="Adam" aria-describedby="nameHelp"
                           value="${employee.name}">
                    <small id="nameHelp" class="text-muted">Wprowadź imię pracownika</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="lastName">Nazwisko</label>
                    <input type="text"
                           name="lastName" id="lastName" class="form-control" placeholder="Nowak"
                           aria-describedby="lastNameHelp" value="${employee.last_name}">
                    <small id="lastNameHelp" class="text-muted">Wprowadź nazwisko pracownika</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="address">Adres</label>
                    <input type="text"
                           name="address" id="address" class="form-control" placeholder="ul.Warszawska 45 80-180 Gdańsk"
                           aria-describedby="addressHelp" value="${employee.address}">
                    <small id="addressHelp" class="text-muted">Wprowadź adres pracownika</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="phone">Telefon</label>
                    <input type="number"
                           name="phone" id="phone" class="form-control" placeholder="848565245"
                           aria-describedby="phoneHelp" value="${employee.phone}">
                    <small id="phoneHelp" class="text-muted">Wprowadź telefon pracownika</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="manHour">PLN/h</label>
                    <input type="number" step="0.01"
                           name="manHour" id="manHour" class="form-control" placeholder="15,20"
                           aria-describedby="manHourHelp" value="${employee.man_hour}">
                    <small id="manHourHelp" class="text-muted">Wprowadź stawkę pracownika za godzinę pracy</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="note">Notatka</label>
                    <input type="text"
                           name="note" id="note" class="form-control" placeholder="Dobry pracownik"
                           aria-describedby="noteHelp" value="${employee.note}">
                    <small id="noteHelp" class="text-muted">Wprowadź notatkę dotyczącą pracownika</small>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
    </form>
</div>
<%@include file="../WEB-INF/footer.jsp" %>