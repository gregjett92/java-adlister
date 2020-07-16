<%--
  Created by IntelliJ IDEA.
  User: gregjett
  Date: 7/15/20
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("isAdmin", false); %>
<% request.setAttribute("myTasks", new String[] {"Todo 1", "Todo 2", "Todo 3"}); %>
<html>
<head>
    <title>To Do List</title>
</head>
<body>
<h1>Welcome to your to do list!</h1>

<c:choose>
    <c:when test="${isAdmin}">
        <%@ include file="partials/admin-nav.jsp"%>
        <ul>
            <c:forEach items="${myTasks}" var="task">
                <li>${task}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <%@ include file="partials/navbar.jsp"%>
    </c:otherwise>
</c:choose>

<h1>Here are your To Do's:</h1>


<c:if test="${isAdmin}">
    <p>Super secret Admin Dashboard!</p>
</c:if>
</body>
</html>
