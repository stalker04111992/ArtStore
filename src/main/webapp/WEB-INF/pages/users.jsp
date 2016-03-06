<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Просмотр контактов</title>
   <!-- <script language="JavaScript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
  -->  <link href="css/table.css" rel="stylesheet" type="text/css">

    <!--<script src="js/jquery.js"/>-->
</head>
<body>
    <jsp:include page="header.jsp"/>

    <table id="table11" class="simple-little-table" cellspacing="0">

        <tr>
            <th>№</th>
            <th>Имя пользователя</th>
            <th>Email</th>
        </tr>


        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${i = userList.indexOf(user)+1}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        </c:forEach>



    </table>



</body>
</html>
