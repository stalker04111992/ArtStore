<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/styleLogin.css" media="screen" type="text/css" />
   <title>Регистрация</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="login">
        <form action="registration" method="post">
            <fieldset class="clearfix">
                <p><span class="fontawesome-user"></span><input name="username" value="${username}" type="text" placeholder="Логин"></p>
                <p><span class="fontawesome-lock"></span><input name="password" value="${password}" type="password"  placeholder="Пароль"></p>
                <p><span class="fontawesome-lock"></span><input name="password2" value="${password}" type="password"  placeholder="Повторите пароль"></p>
                <p><span class="fontawesome-lock"></span><input name="email" value="${email}" type="email"  placeholder="Email"></p>
                <p><input type="submit" value="РЕГИСТРАЦИЯ"></p>
            </fieldset>
        </form>
   </div>

<footer class="footer">
    <div class="containerFooter">
        <div class="wrapperFooter">
            <div class="fleft">Copyright - All Rights Reserved</div>
            <div class="fright"><a rel="nofollow" href="http://www.templatemonster.com/" target="_blank">Website template</a> <span id="textFooter">designed by TemplateMonster.com&nbsp; &nbsp; |&nbsp; &nbsp;</span><a href="http://templates.com/product/3d-models/" target="_blank">3D Models</a> provided by Templates.com</div>
        </div>
    </div>
</footer>

</body>
</html>
