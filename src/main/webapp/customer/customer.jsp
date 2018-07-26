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
    <h1>Pracownicy</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Imie</th>
            <th scope="col">Nazwisko</th>
            <th scope="col">Data Urodzenia</th>
            <th scope="col"></th>
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
                    <a href="/deleteCustomer?id=${customer.id}" class="btn btn-danger" role="button">Usuń</a>
                </td>
                <td>
                    <a href="/editCustomer?id=${customer.id}" class="btn btn-danger" role="button">Edytuj</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../WEB-INF/footer.jsp" %>
