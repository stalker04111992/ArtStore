package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/about", "/index", "/news"})
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("/about")){
            request.getRequestDispatcher("WEB-INF/pages/about.jsp").forward(request, response);
        }
        if (uri.contains("/index")){
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
        }
        if (uri.contains("/news")){
            request.getRequestDispatcher("WEB-INF/pages/news.jsp").forward(request, response);
        }
    }
}
