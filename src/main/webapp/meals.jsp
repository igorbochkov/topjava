<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<a href="index.html">HOME</a>
<hr>
<table frame="border" rules="all" align="center" border="1">
    <caption>MEALS</caption>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>

    <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>

    <c:forEach var="meal" items="${mealsTo}">

        <c:if test="${meal.isExcess() == true}">
            <tr style="color: red">
                <td>${meal.id}</td>
                <td>${meal.getDateTime().toLocalDate()} ${meal.getDateTime().toLocalTime()}</td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>
                <td><a href="update?id=${meal.getId()}">Update</a></td>
                <td><a href="delete?id=${meal.getId()}">Delete</a> </td>
            </tr>
        </c:if>
        <c:if test="${meal.isExcess() != true}">
            <tr style="color: green">
                <td>${meal.getId()}</td>
                <td>${meal.getDateTime().toLocalDate()} ${meal.getDateTime().toLocalTime()}</td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>
                <td><a href="update?id=${meal.getId()}">Update</a></td>
                <td><a href="delete?id=${meal.getId()}">Delete</a> </td>
            </tr>
        </c:if>

    </c:forEach>
</table>

<hr>
<a href="new.jsp">Add new Meal</a>
</body>
</html>
