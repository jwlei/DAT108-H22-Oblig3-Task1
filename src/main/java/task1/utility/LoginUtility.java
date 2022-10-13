package task1.utility;

import task1.model.Cart;

import javax.servlet.http.HttpSession;

public class LoginUtility {

    private final static int MAX_INTERACTIVE_INTERVAL = 60; // Seconds

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
