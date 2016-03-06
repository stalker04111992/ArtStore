<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ошибка входа</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Вход не выполнен</h1>
<p>Unfortunately an unexpected error has occurred. Below you can find the error details.</p>
<h2>Details</h2>
<ul>


    <li>Дата и время: <fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long" />
    <li>URI: <c:out value="${requestScope['javax.servlet.forward.request_uri']}" />
    <li>Браузер: <c:out value="${header['user-agent']}" />
</ul>
</body>
</html>