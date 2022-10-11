package task1.utility;

import task1.model.ShoppingList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtility {

    private final static int MAX_INTERACTIVE_INTERVAL = 60; // Seconds

    public static void logOff(HttpSession session) {
        session.invalidate();
    }

    public static void logIn(HttpSession session, String password) {
        logOff(session);

        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("shoppingList", new ShoppingList());
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("shoppingList") != null;
    }
}
