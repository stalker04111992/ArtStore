<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Магазин художественных товаров</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
  </head>

  <body>

  <jsp:include page="header.jsp"/>
  <jsp:include page="slider.jsp"/>



  <div class="main-box">

      <div id="imgleft"></div>
      <div id="imgright"></div>

      <div class="containerIndex">
          <div class="inside">
              <div class="wrapper">
                  <!-- aside -->
                  <aside>
                      <h2>Recent <span>News</span></h2>
                      <!-- .news -->
                      <ul class="news">
                          <li>
                              <figure><strong>22</strong>June</figure>
                              <h3><a href="#">Sed ut perspiciatis unde</a></h3>
                              Domnis iste natus error sit voluptam accusa doloremque <a class = "indexLink" href="#">...</a>
                          </li>
                          <li>
                              <figure><strong>09</strong>June</figure>
                              <h3><a href="#">Totam rem aperiam</a></h3>
                              Eaqueipsa quae abillo inventoretis et quasi architecto beatae <a class = "indexLink" href="#">...</a>
                          </li>
                          <li>
                              <figure><strong>31</strong>May</figure>
                              <h3><a href="#">Inventore veritatis et quasi</a></h3>
                              Architecto beatae vitae dicta sunt explicabo <a class = "indexLink" href="#">...</a>
                          </li>
                          <li>
                              <figure><strong>25</strong>May</figure>
                              <h3><a href="#">Nemo enim ipsam</a></h3>
                              Voluptatem quia voluptas sit asper natur aut odit aut fugit <a class = "indexLink" href="#">...</a>
                          </li>
                      </ul>
                      <!-- /.news -->
                  </aside>
                  <!-- content -->
                  <section id="content">
                      <article>
                          <h2>Welcome to <span>Our Design Company!</span></h2>
                          <p>Design Company is a free web template created by TemplateMonster.com team. This website template is optimized for 1024X768 screen resolution. It is also HTML5 &amp; CSS3 valid.</p>
                          <figure><a class = "indexLink" href="#"><img src="images/banner1.jpg" alt=""></a></figure>
                          <p>This website template has several pages: <a class = "indexLink" href="index">Home</a>, <a class = "indexLink" href="about">About us</a>, <a class = "indexLink" href="privacy">Privacy Policy</a>, <a class = "indexLink" href="gallery">Gallery</a>, <a class = "indexLink" href="contacts.html">Contact us</a> (note that contact us form – doesn’t work), <a class = "indexLink" href="sitemap">Site Map</a>.</p>
                          This website template can be delivered in two packages - with PSD source files included and without them. If you need PSD source files, please go to the template download page at TemplateMonster to leave the e-mail address that you want the template ZIP package to be delivered to.
                      </article>
                  </section>
              </div>
          </div>


      </div>



  </div>





<jsp:include page="footer.jsp"/>

  <script type="text/javascript">

      $(document).ready(function() {
          Active(0);
          Cufon.now();
      })
  </script>

</body>
</html>
