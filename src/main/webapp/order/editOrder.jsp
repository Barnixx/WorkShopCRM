<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 28.07.2018
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/order">Zlecenie</a></li>
        <li class="breadcrumb-item"><a href="/orderDetails?id=${order.id}">Zlecenie NR ${order.id}</a></li>
        <li class="breadcrumb-item active">Edytuj Zlecenie</li>
    </ol>
    <form method="post">
        <input type="number" value="${order.id}" hidden>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="dateOfAccepting">Data akceptacji</label>
                    <input type="date"
                           name="dateOfAccepting" id="dateOfAccepting" class="form-control" placeholder="22.05.2018"
                           aria-describedby="helpDataAccepting" value="${order.date_of_accepting}" required>
                    <small id="helpDataAccepting" class="text-muted">Podaj date akceptacji</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="plannedStartDate">Planowany czas rozpoczęcia naprawy</label>
                    <input type="date"
                           name="plannedStartDate" id="plannedStartDate" class="form-control" placeholder="22.08.2017"
                           aria-describedby="plannedStartDateHelp" value="${order.planned_start_date}" required>
                    <small id="plannedStartDateHelp" class="text-muted">Wprowadź planowaną date rozpoczęcia naprawy
                    </small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="endDate">Data zakończenia</label>
                    <input type="date"
                           name="endDate" id="endDate" class="form-control" placeholder="22.05.2018"
                           aria-describedby="endDateHelp" value="${order.end_date}">
                    <small id="endDateHelp" class="text-muted">Podaj datę zakończenia</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="status">Status</label>
                    <select name="status" id="status" class="form-control" aria-describedby="helpId">
                        <option value="Przyjęty" ${order.status eq 'Przyjęty' ? "selected" : ""}>Przyjęty</option>
                        <option value="Zatwierdzone koszty naprawy" ${order.status eq 'Zatwierdzone koszty naprawy' ? "selected" : ""}>
                            Zatwierdzone koszty naprawy
                        </option>
                        <option value="W naprawie" ${order.status eq 'W naprawie' ? "selected" : ""}>W naprawie</option>
                        <option value="Gotowy do odbioru" ${order.status eq 'Gotowy do odbioru' ? "selected" : ""}>
                            Gotowy do odbioru
                        </option>
                        <option value="Rezygnacja" ${order.status eq 'Rezygnacja' ? "selected" : ""}>Rezygnacja</option>
                    </select>
                    <small id="helpId" class="text-muted">Wybierz status zlecenia</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="descriptionOfTheProblem">Opis Problemu </label>
                    <textarea name="descripionOfTheProblem" id="descriptionOfTheProblem" class="form-control" cols="20"
                              rows="5" placeholder="Opis"
                              aria-describedby="descriptionOfTheProblemHelp">${order.description_of_the_problem}</textarea>
                    <small id="descriptionOfTheProblemHelp" class="text-muted">Wprowadź opis problemu</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="repairDescription">Opis Naprawy</label>
                    <textarea name="repairDescription" id="repairDescription" cols="20" rows="5" class="form-control"
                              placeholder="Opis Naprawy"
                              aria-describedby="repairDescriptionHelp">${order.repair_description}</textarea>
                    <small id="repairDescriptionHelp" class="text-muted">Wprowadź opis naprawy</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="repairCost">Koszt naprawy</label>
                    <input type="number" step="0.01"
                           name="repairCost" id="repairCost" class="form-control" placeholder="34.54"
                           aria-describedby="repairCostHelp" value="${order.repair_cost}">
                    <small id="repairCostHelp" class="text-muted">Wpisz koszt naprawy</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="partCost">Koszt części</label>
                    <input type="number" step="0.01"
                           name="partCost" id="partCost" class="form-control" placeholder="45.33"
                           aria-describedby="partCostHelp" value="${order.part_cost}">
                    <small id="partCostHelp" class="text-muted">Wpisz koszt części</small>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="manHours">Ilość roboczogodzin</label>
                    <input type="number"
                           name="manHours" id="manHours" class="form-control" placeholder="5"
                           aria-describedby="manHoursHelp" value="${order.man_hours}">
                    <small id="manHoursHelp" class="text-muted">Wpisz ilość roboczogodzin</small>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="employee_id">Pracownik</label>
                    <select class="form-control" name="employee_id" id="employee_id">
                        <option value="0"></option>
                        <c:forEach items="${employees}" var="employee">
                            <option value="${employee.id}" ${employee.id == order.employee.id ? 'selected':""}>${employee.name} ${employee.last_name}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="customer_id">Klient</label>
                    <select class="form-control" name="customer_id" id="customer_id">
                        <c:forEach items="${customers}" var="customer">
                            <option value="${customer.id}" ${customer.id == order.customer.id ? 'selected':""}>${customer.name} ${customer.last_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="vehicle_id">Pojazd</label>
                    <select class="form-control" name="vehicle_id" id="vehicle_id">
                        <c:forEach items="${vehicles}" var="vehicle">
                            <option value="${vehicle.id}" ${vehicle.id == order.vehicle.id ? 'selected':""}>${vehicle.brand} ${vehicle.model} ${vehicle.license_plate}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz</button>
    </form>
</div>
<%@include file="../WEB-INF/footer.jsp" %>

