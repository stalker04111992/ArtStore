<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Каталог</title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
</head>
<body>
<jsp:include page="header.jsp"/>
    <script type="text/javascript">
        $(document).ready(function() {
            Active(1);
        })
    </script>
<jsp:include page="slider.jsp"/>


<div class="main-box">

    <div id="imgleft"></div>
    <div id="imgright"></div>

    <div class="containerCatalog">
        <div class="inside">
            <div class="wrapper">
                <!-- aside -->
                <aside id="menuCatalog">
                    <h2>Категории</h2>
                    <!-- .news -->
                    <ul class="news">
                        <li>
                            <h4><a href="#">Художественная бумага</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Графические материалы</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Кисти</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Художественные краски</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Мольберты и планшеты</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Мастихины и палитры</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Грунт и жидкости</a></h4>
                        </li>
                        <li>
                            <h4><a href="#">Холсты</a></h4>
                        </li>
                    </ul>
                    <!-- /.news -->
                </aside>
                <!-- content -->
               <!-- <section id="content">
                    <article>
                        <h2>Welcome to <span>Our Design Company!</span></h2>
                        <p>Design Company is a free web template created by TemplateMonster.com team. This website template is optimized for 1024X768 screen resolution. It is also HTML5 &amp; CSS3 valid.</p>
                        <figure><a href="#"><img src="images/banner1.jpg" alt=""></a></figure>
                        <p>This website template has several pages: <a href="index.html">Home</a>, <a href="about.html">About us</a>, <a href="privacy.html">Privacy Policy</a>, <a href="gallery.html">Gallery</a>, <a href="contacts.html">Contact us</a> (note that contact us form – doesn’t work), <a href="sitemap">Site Map</a>.</p>
                        This website template can be delivered in two packages - with PSD source files included and without them. If you need PSD source files, please go to the template download page at TemplateMonster to leave the e-mail address that you want the template ZIP package to be delivered to.
                    </article>
                </section> -->
            </div>
        </div>


    </div>



</div>


<jsp:include page="footer.jsp"/>

</body>
</html>
