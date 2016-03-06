<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>О нас</title>
    <link rel="stylesheet" href="css/about.css" type="text/css" media="all">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="slider.jsp"/>
<script type="text/javascript">
    $(document).ready(function() {
        Active(4);
    })
</script>

<div class="main-box">
    <div class="containerContact">
        <div class="inside">
            <div class="wrapper">
                <!-- aside -->
                <aside>
                    <h2 class = "title">
                        Контакты
                    </h2>
                    <!-- .contacts -->
                    <ul class="contacts">
                        <li><strong>Zip Code:</strong>50122</li>
                        <li><strong>Country:</strong>USA</li>
                        <li><strong>City:</strong>New York</li>
                        <li><strong>Telephone 1:</strong>+354 5635600</li>
                        <li><strong>Fax:</strong>+354 5635620</li>
                        <li><strong>Email:</strong><a class="contactsLink" href="#">businessco@mail.com</a></li>
                    </ul>
                    <!-- /.contacts -->
                    <h3>Miscellaneous info:</h3>
                    Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae.
                </aside>
                <!-- content -->
                <section id="content">
                    <article>
                        <h2 class = "title">
                            Отправить письмо
                        </h2>
                            <form method="post" action="" id="contacts-form">
                            <fieldset>
                                <div class="field">
                                    <label>Your Name:</label>
                                    <input type="text" value="">
                                </div>
                                <div class="field">
                                    <label>Your E-mail:</label>
                                    <input type="email" value="">
                                </div>
                                <div class="field">
                                    <label>Your Website:</label>
                                    <input type="url" value="">
                                </div>
                                <div class="field">
                                    <label>Your Message:</label>
                                    <textarea></textarea>
                                </div>
                                <label><a onclick="document.getElementById('contacts-form').submit()" class = "contactsLink" href="#">Отправить письмо</a></label>
                            </fieldset>
                        </form>
                    </article>
                </section>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
