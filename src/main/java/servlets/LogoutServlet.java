package servlets;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/j_security_logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //set response headers
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", new Date().toString());
        //invalidate session and remove cache
        invalidateSession(request);
        String url = redirectedURL(request);
        response.sendRedirect(url);
    }

    private void invalidateSession(HttpServletRequest request){
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                ObjectName jaasMgr = new ObjectName("jboss.as:subsystem=security,security-domain=auth");
                Object[] params = {request.getRemoteUser()};
                String[] signature = {"java.lang.String"};
                MBeanServer server = MBeanServerFactory.findMBeanServer(null).get(0);
                server.invoke(jaasMgr, "flushCache", params, signature);
                session.invalidate();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @NotNull
    private String redirectedURL(HttpServletRequest request){
        String url = request.getHeader("referer");
        if (url == null){
            url = "index";
        }
        return url;
    }
}
