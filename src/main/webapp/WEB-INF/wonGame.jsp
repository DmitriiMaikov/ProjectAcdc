<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Win!</title>
</head>
<body style="text-align: center;">
<h1>Поздравляем, ${sessionScope.name}!</h1>
<p>Вы отлично знаете Java!</p>

<form action="/start" method="post">
    <input type="hidden" name="name" value="${sessionScope.name}"/>
    <input type="submit" value="Начать новую игру"/>
</form>
</body>
</html>
