package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/mail")
public class SendMail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
/*
        final String username = "stalker04111992@gmail.com";
        final String password = "3824887asd";

        Mail mail = new Mail(username, password);

        Session session = Session.getInstance(mail.getProperties(),
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stalker11@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("stalker04111992@mail.ru"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);
            System.out.println("Sent message successfully....");*/
        }catch (Exception mex) {
            mex.printStackTrace();
        }
        finally {
            request.getRequestDispatcher("WEB-INF/pages/catalog.jsp").forward(request, response);
        }


    }
}
