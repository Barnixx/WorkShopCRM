<%--
  Created by IntelliJ IDEA.
  User: barni
  Date: 27.07.18
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/customer">Klienci</a></li>
        <li class="breadcrumb-item active">Dodaj Klienta</li>
    </ol>
    <form method="post">
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="name">Imie</label>
                    <input type="text"
                           name="name" id="name" class="form-control" placeholder="Adam" aria-describedby="nameHelp">
                    <small id="nameHelp" class="text-muted">Wprowadź imię klienta</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="lastName">Nazwisko</label>
                    <input type="text"
                           name="lastName" id="lastName" class="form-control" placeholder="Nowak"
                           aria-describedby="lastNameHelp">
                    <small id="lastNameHelp" class="text-muted">Wprowadź nazwisko klienta</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="dateOfBirth">Data Urodzenia</label>
                    <input type="date"
                           name="dateOfBirth" id="dateOfBirth" class="form-control" placeholder="Dobry pracownik"
                           aria-describedby="dateOfBirthHelp">
                    <small id="dateOfBirthHelp" class="text-muted">Wprowadź date urodzenia klienta</small>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
    </form>
</div>
<%@include file="../WEB-INF/footer.jsp" %>