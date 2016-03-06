package servlets;

import entities.User;
import services.HashPassword;
import services.UserDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    @EJB
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String password1 = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");

        try{
            User user = userDao.findByUsername(username);
            if (user != null){

            }

            if (!password1.equals(password2)){

            }
            String hashPassword = HashPassword.getHashPassword(username, password1);
            User user1 = new User(username, hashPassword, 1, email);
            userDao.save(user);
        }
        catch (Exception exception){

        }

    }
}
