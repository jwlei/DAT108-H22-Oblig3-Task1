package task1.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import task1.model.Cart;

import javax.servlet.http.HttpSession;

public class SessionUtility {

    private final static int MAX_INTERACTIVE_INTERVAL = 20; // Seconds

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;

    public static void logOff(HttpSession session) {
        session.invalidate();
    }

    public static void logIn(HttpSession session) {

        if (isLoggedIn(session)) {
            session.getAttribute("cart");
        } else {
            session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
            session.setAttribute("cart", new Cart());
            session.setAttribute("loggedIn", true);
        }
    }

    public static boolean isLoggedIn(HttpSession session) {

        return session != null && session.getAttribute("cart") != null;
    }
}
