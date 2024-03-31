<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная страница</title>
</head>
<body style="text-align: center;">
<h1><%= "Путешествие в мир Java" %>
</h1>
<h3>Легкие вопросы, для освежения памяти.</h3>
<br/>

<form action="start" method="post">
    <label>
        <input type="text" name="name" placeholder="Введите свое имя" />
    </label>
    <input type="submit" value="Go to game" />
</form>
</body>
</html>
