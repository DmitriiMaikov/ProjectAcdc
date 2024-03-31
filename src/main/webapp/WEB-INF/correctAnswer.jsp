<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Correct answers</title>
</head>
<body style="text-align: center;">
<h1>Это правильный ответ: ${requestScope.answer}</h1>

<form action="logic-servlet" method="post">
    <input type="hidden" name="answer" value="${requestScope.answer}"/>
    <input type="submit" value="Go next"/>
</form>
</body>
</html>
