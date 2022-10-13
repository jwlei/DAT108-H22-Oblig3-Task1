package task1.utility;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpSession;

import task1.model.Cart;


public class SessionUtility {

    private final static int MAX_INTERACTIVE_INTERVAL = 60; // Seconds for an active session


    public static void logOff(HttpSession session) {
        session.invalidate();
    }


    /**
     * Checks if the session is active, get the cart from the session
     * if the session is expired, create a new cart and add it to the session
     * @param session
     */
    public static void logIn(HttpSession session) {

        if (isLoggedIn(session)) {
            session.getAttribute("cart");

        } else {
            session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
            session.setAttribute("cart", new Cart());
            session.setAttribute("loggedIn", true);
        }
    }

    /**
     * Checks if the session is active
     * @param session
     * @return
     */
    public static boolean isLoggedIn(HttpSession session) {

        return session != null && session.getAttribute("cart") != null;
    }
}
