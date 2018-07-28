<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/vehicle">Pojazdy</a></li>
        <li class="breadcrumb-item active">Dodaj Pojazd</li>
    </ol>
    <form method="post">
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="brand">Marka</label>
                    <input type="text"
                           name="brand" id="brand" class="form-control" placeholder="Opel" aria-describedby="brandHelp">
                    <small id="brandHelp" class="text-muted">Wprowadź markę pojazdu</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="model">Model</label>
                    <input type="text"
                           name="model" id="model" class="form-control" placeholder="Insignia"
                           aria-describedby="modelHelp">
                    <small id="modelHelp" class="text-muted">Wprowadź model pojazdu</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="yearOfProduction">Rok produkcji</label>
                    <input type="date"
                           name="yearOfProduction" id="yearOfProduction" class="form-control" placeholder="28.03.2014"
                           aria-describedby="yearOfProductionHelp">
                    <small id="yearOfProductionHelp" class="text-muted">Wprowadź rok produkcji pojazdu</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="licensePlate">Numer Rejestracyjny</label>
                    <input type="text"
                           name="licensePlate" id="licensePlate" class="form-control" placeholder="GD55658"
                           aria-describedby="licensePlateHelp">
                    <small id="licensePlateHelp" class="text-muted">Wprowadź numer rejestracyjny pojazdu</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="nextInspection">Następny przegląd</label>
                    <input type="date"
                           name="nextInspection" id="nextInspection" class="form-control" placeholder="28.03.2019"
                           aria-describedby="nextInspectionHelp">
                    <small id="nextInspectionHelp" class="text-muted">Wprowadź data kolejnego przeglądu</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="customer_id">Właściciel</label>
                    <select class="form-control" id="customer_id" name="customer_id" onselect="">
                        <c:forEach items="${customers}" var="customer">
                            <option value="${customer.id}">${customer.name} ${customer.last_name}</option>
                        </c:forEach>
                        <option value="0"></option>
                    </select>

                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
    </form>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
</html>
