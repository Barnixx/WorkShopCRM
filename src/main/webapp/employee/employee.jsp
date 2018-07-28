<%--
  Created by IntelliJ IDEA.
  User: Barni
  Date: 26.07.2018
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item active">Pracownicy</li>
    </ol>
    <h1>Klienci</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Imie</th>
            <th scope="col">Nazwisko</th>
            <th scope="col">Adres</th>
            <th scope="col">Telefon</th>
            <th scope="col">Roboczogodzina</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.last_name}</td>
                <td>${employee.address}</td>
                <td>${employee.phone}</td>
                <td>${employee.man_hour} PLN</td>
                <td>
                    <a href="/employeeDetails?id=${employee.id}" class="btn btn-info" role="button">Sczegóły</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
