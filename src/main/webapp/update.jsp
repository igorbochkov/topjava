
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<a href="index.html">HOME</a>
<hr>

<h2>Update Meal</h2>

<form action="update" method="get" style="align-content: center">
    <label for="data">DataTime</label>
    <input type="datetime-local" id="data" name="data" value="${localDateTime}">
    <br>

    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${description}">
    <br>

    <label for="calories">Calories</label>
    <input type="text" id="calories" name="calories" value="${calories}">
    <br>

    <label for="id" hidden>id</label>
    <input type="text" id="id" name="id" hidden value="${id} ">
    <br>

    <input type="submit" value="UPDATE"/>
</form>
</body>
</html>
