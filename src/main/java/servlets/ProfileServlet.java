package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String url = request.getRequestURI();
        boolean b = request.isUserInRole("Admin");
        String name = request.getRemoteUser();
        int x = 0;
        request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
    }
}
