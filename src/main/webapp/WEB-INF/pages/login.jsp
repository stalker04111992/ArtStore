<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/styleLogin.css" media="screen" type="text/css" />
    <title>Авторизация</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="login">
        <form action="j_security_check" method="post">
            <fieldset class="clearfix">
                <p><span class="fontawesome-user"></span><input name="j_username" value="${username}" type="text" placeholder="Логин"></p>
                <p><span class="fontawesome-lock"></span><input name="j_password" value="${password}" type="password"  placeholder="Пароль"></p>
                <p><input type="submit" value="ВОЙТИ"></p>
            </fieldset>
        </form>
   </div>

<a href="twitter">Twitter</a>
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
