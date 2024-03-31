<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lose!</title>
</head>
<body style="text-align: center;">
<h1>${sessionScope.name}, видимо вам надо немного подучить Java :)</h1>
<p>Попробуйте начать заново!</p>

<form action="/start" method="post">
    <input type="hidden" name="name" value="${sessionScope.name}"/>
    <input type="submit" value="Начать новую игру"/>
</form>
</body>
</html>