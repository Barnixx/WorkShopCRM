<!--
Created by IntelliJ IDEA.
User: Barni
Date: 26.07.2018
Time: 12:24
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>${title}</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet"
          href='<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>'
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/css/style.css" TYPE="text/css">

    <!--  -->
    <script defer src='<c:url value="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"/>'
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"></script>
    <script defer src='<c:url value="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" />'
            integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
            crossorigin="anonymous"></script>

</head>

<body>

<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>Warsztat u Stasia</h3>
            <strong>WS</strong>
        </div>

        <ul class="list-unstyled components">
            <li class="active">
                <a href="/">
                    <i class="fas fa-home"></i>
                    Strona główna
                </a>
            </li>
            <li>
                <a href="#pageEmployee" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-user"></i>
                    Pracownicy
                </a>
                <ul class="collapse list-unstyled" id="pageEmployee">
                    <li>
                        <a href="/employee">Pracownicy</a>
                    </li>
                    <li>
                        <a href="/addEmployee">Dodaj Pracownika</a>
                    </li>
                    <li>
                        <a href="/employeeRaport">Raport</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#pageCustomer" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-user"></i>
                    Klienci
                </a>
                <ul class="collapse list-unstyled" id="pageCustomer">
                    <li>
                        <a href="/customer">Klienci</a>
                    </li>
                    <li>
                        <a href="/addCustomer">Dodaj Klienta</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#pageVehicle" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-user"></i>
                    Pojazdy
                </a>
                <ul class="collapse list-unstyled" id="pageVehicle">
                    <li>
                        <a href="/vehicle">Pojazdy</a>
                    </li>
                    <li>
                        <a href="/addVehicle">Dodaj Pojazd</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#pageOrder" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-user"></i>
                    Zlecenia
                </a>
                <ul class="collapse list-unstyled" id="pageOrder">
                    <li>
                        <a href="/order">Zlecenia</a>
                    </li>
                    <li>
                        <a href="/addOrder">Dodaj Zlecenie</a>
                    </li>
                    <li>
                        <a href="/">Raport</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>

    <!-- Page Content  -->
    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span></span>
                </button>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-align-justify"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/employee">Pracownicy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer">Klienci</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/vehicle">Pojazdy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/order">Zlecenia</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>