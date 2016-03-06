package callback;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/callback")
public class TwitterCallback extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        String url1 = request.getHeader("referer");
        final OAuthService service = new ServiceBuilder()
                .provider(TwitterApi.SSL.class)
                .apiKey("KhjqEDgtkMlHGYT4soqgD62LC")
                .apiSecret("oYF1cHSU23kgNAztTIfoCzfbV3GSsL0qdy377pB1UBHLUocPwn")
                .callback("http://127.0.0.1:8080/ArtStore/callback")
                .build();

        String token = request.getParameter("oauth_token");
        String verifier = request.getParameter("oauth_verifier");

        if (token == null){
            throw new NullPointerException();
        }

        Token accessToken = service.getAccessToken(new Token(token, "NY8QypS4TPeG9G7ISbfe4ZWynfFk8Wii3yN71KbHGAl0e"), new Verifier(verifier));
        OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
        service.signRequest(accessToken, oauthRequest);
        Response oauthResponse = oauthRequest.send();
        JsonParser jsonParser = new JsonParser();
        JsonObject authData = jsonParser.parse(oauthResponse.getBody()).getAsJsonObject();
        String username = authData.getAsJsonPrimitive("name").getAsString();
        String id = authData.getAsJsonPrimitive("id").getAsString();

        request.getSession(false).setAttribute("username", username);
        request.getSession(false).setAttribute("password", "14");

        response.setStatus(302);
        response.setHeader("Location", "http://localhost:8080/ArtStore/profile");
        response.sendRedirect("profile");
    }

}
