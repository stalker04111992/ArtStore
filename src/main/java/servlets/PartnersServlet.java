package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class PartnersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //request.getSession(false).setAttribute("username", "313");
       // request.getSession(false).setAttribute("password", "14");

        response.setStatus(302);
        response.setHeader("Location", "http://localhost:8080/ArtStore/profile");
        response.sendRedirect("profile");
    }
}