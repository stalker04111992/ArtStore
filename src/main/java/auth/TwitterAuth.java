package auth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/twitter")
public class TwitterAuth extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            String url1 = request.getHeader("referer");
            final OAuthService service = new ServiceBuilder()
                .provider(TwitterApi.SSL.class)
                .apiKey("KhjqEDgtkMlHGYT4soqgD62LC")
                .apiSecret("oYF1cHSU23kgNAztTIfoCzfbV3GSsL0qdy377pB1UBHLUocPwn")
                .callback("http://127.0.0.1:8080/ArtStore/callback")
                .build();

                Token requestToken = service.getRequestToken();
            request.getSession().setAttribute("twitter", service);
            request.getSession().setAttribute("request_token", requestToken);
            String url = service.getAuthorizationUrl(requestToken);
            response.sendRedirect(url);
        }
        catch (IOException e) {
        }


    }
}
