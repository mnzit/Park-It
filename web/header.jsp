<%-- 
    Document   : header
    Created on : Jul 15, 2018, 1:40:05 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/tippy.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <title>Park it!</title>
    </head>
    <div class="navbar-fixed">
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo ml-4">Park It!</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="aboutus.jsp">ABOUT US</a></li>
                    <li><a href="contactus.jsp">CONTACT US</a></li>
                    <%if (session.getAttribute("username") != null) { %><li><a href="welcome.jsp" class="toUpper">dashboard</a></li> <%}%>      
                    <li><a href="" class="toUpper cs"><%if (session.getAttribute("username") != null) { %> Logged in by ${username} |<%}%></a></li>
                    <%if (session.getAttribute("username") != null) {%><li><form action="Logout"><a href=""><button class="btn btn-success logger" data-toggle="tooltip" title="<%if (session.getAttribute("username") != null) { %> Logged in by ${username}<%}%>" type="submit">Logout</button></a></form></li><%}%>
                </ul>
            </div>
        </nav>
    </div>
    <ul class="sidenav" id="mobile-demo">
        <%if (session.getAttribute("username") != null) { %> <li><a href="welcome.jsp" class="nav-item nav-link toUpper">${username} dashboard </a></li><%}%>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="aboutus.jsp">ABOUT US</a></li>
        <li><a href="contactus.jsp">CONTACT US</a></li>
        <% if (session.getAttribute("username") != null) {  %><li><form action="Logout"><button class="btn btn-success logoutm" type="submit">Log out</button></form></li><%}%>
    </ul>
    <body>
        <div class="container" style="margin-top:100px;margin-bottom:100px;">