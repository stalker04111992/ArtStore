<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
    <title>Новости</title>
</head>
<body>



        <jsp:include page="header.jsp"/>
        <jsp:include page="slider.jsp"/>
        <div class="main-box">

            <div id="imgleft"></div>
            <div id="imgright"></div>
        </div>

        <jsp:include page="footer.jsp"/>


    <script type="text/javascript">
        $(document).ready(function() {
            Active(3);
        })
    </script>

</body>
</html>
