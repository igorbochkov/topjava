<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Meal</title>
</head>
<body>
<a href="index.html">HOME</a>
<hr>

<h2>Add new Meal</h2>

<form action="new" method="get">
    <label for="data">DataTime</label>
    <input type="datetime-local" id="data" name="data">
    <br>

    <label for="description">Description</label>
    <input type="text" id="description" name="description">
    <br>

    <label for="calories">Calories</label>
    <input type="text" id="calories" name="calories">
    <br>

    <input type="submit" value="SAVE"/>
</form>
</body>
</html>
