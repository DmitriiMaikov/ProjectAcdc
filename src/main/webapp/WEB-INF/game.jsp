<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Квест</title>

</head>
<body style="text-align: center;">
<h2>Вопрос: ${requestScope.question}</h2>
<form action="controller" method="post">
    <label>
        <input type="radio" name="answer" value="${requestScope.answer1}"/>
    </label> ${requestScope.answer1}
    <label>
        <input type="radio" name="answer" value="${requestScope.answer2}"/>
    </label> ${requestScope.answer2}
    <input type="submit" value="Submit" />
</form>
</body>
</html>