package task1.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import task1.model.Cart;


public class SessionUtility {

    private final static int MAX_INTERACTIVE_INTERVAL = 60; // Seconds for an active session


    /**
     * Method to invalidate the session
     * @param session
     */
    public static void logOut(HttpSession session) {
        session.invalidate();
    }


    /**
     * Checks if the session is active, get the cart from the session
     * if the session is expired, create a new cart and add it to the session
     * @param request
     */
    public static void logIn(HttpServletRequest request) {

        // Invalidate any current session before creating a new one
        logOut(request.getSession());

        // Create a new session
        HttpSession session = request.getSession();

        if (isLoggedIn(session)) {
            session.getAttribute("cart");
        } else {
            session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
            session.setAttribute("cart", new Cart());
            session.setAttribute("loggedIn", true);
        }
    }


    /**
     * Checks if the current session is active
     * @param session
     * @return boolean
     */
    public static boolean isLoggedIn(HttpSession session) {

        return session != null && session.getAttribute("cart") != null;
    }
}
