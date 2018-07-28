<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 29.07.2018
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item"><a href="/employee">Pracownicy</a></li>
        <li class="breadcrumb-item active">Raport</li>
    </ol>
    <h1>Raport Godzinowy Pracowników</h1>
    <h3>Wygenaruj Raport</h3>
    <form method="post" action="/employeeRaport" class="form-inline">

        <label class="sr-only" for="startDate">Data początkowa</label>
        <input type="date"
               name="startDate" id="startDate" class="form-control mb-2 mr-sm-2" placeholder="Data Początkowa"
               aria-describedby="startDateHelp"
               required>
        <label class="sr-only" for="endDate">Data końcowa</label>
        <input type="date"
               name="endDate" id="endDate" class="form-control mb-2 mr-sm-2" placeholder="Data końcowa"
               aria-describedby="endDateHelp" required>
        <button type="submit" class="btn btn-primary mb-2">Pokaż</button>
    </form>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Imie i Nazwisko</th>
            <th scope="col">Ilość roboczogodzin</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name} ${employee.last_name}</td>
                <td>${employee.man_hour}</td>
                <td>
                    <a href="/employeeDetails?id=${employee.id}" class="btn btn-info" role="button">Sczegóły</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
