package task1.utility;

import org.springframework.beans.factory.annotation.Value;

public class InputValidator {

    @Value("${app.password}") private static String PASSWORD;

    public static boolean isValidPassword(String password) {
        /**
         * Checks if the password is valid.
         */
        return password != null && password.equals(PASSWORD);
    }
}
