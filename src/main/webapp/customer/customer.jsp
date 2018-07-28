<%--
  Created by IntelliJ IDEA.
  User: barni
  Date: 26.07.18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/header.jsp" %>
<%-- CONTENT --%>
<div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Strona główna</a></li>
        <li class="breadcrumb-item active">Klienci</li>
    </ol>
    <h1>Pracownicy</h1>
    <h3>Znajdź klienta</h3>
    <form method="post" action="/searchCustomer" class="form-inline">

        <label class="sr-only" for="name">Imie</label>
        <input type="text"
               name="name" id="name" class="form-control mb-2 mr-sm-2" placeholder="Imie" aria-describedby="nameHelp"
               required>
        <label class="sr-only" for="lastName">Nazwisko</label>
        <input type="text"
               name="lastName" id="lastName" class="form-control mb-2 mr-sm-2" placeholder="Nazwisko"
               aria-describedby="lastNameHelp" required>
        <button type="submit" class="btn btn-primary mb-2">Szukaj</button>
        <p>${warning}</p>

    </form>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Imie</th>
            <th scope="col">Nazwisko</th>
            <th scope="col">Data Urodzenia</th>
            <th scope="col"></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.last_name}</td>
                <td>${customer.date_of_birth}</td>
                <td>
                    <a href="/customerDetails?id=${customer.id}" class="btn btn-info" role="button">Szczegóły</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
