package servlets;

import services.Mail;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/catalog")
public class CatalogServlet extends HttpServlet {

    @EJB
    private Mail mail;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            mail.sendMessage("stalker@gmail.com", "stalker04111992@mail.ru", "zil", "krut");



        }catch (Exception mex) {
            mex.printStackTrace();
        }
        finally {
            request.getRequestDispatcher("WEB-INF/pages/catalog.jsp").forward(request, response);
        }


    }
}
