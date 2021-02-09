<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Meal</title>
</head>
<body>
<a href="index.html">HOME</a>
<hr>

<h2>Add new Meal</h2>
<form action="new" method="post    ">
    <label for="data">DataTime</label>
    <input type="datetime-local" id="data">
    <br>

    <label for="description">Description</label>
    <input id="description">
    <br>

    <label for="calories">Calories</label>
    <input id="calories">
    <br>

    <input type="submit"/>
</form>
</body>
</html>
