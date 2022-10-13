package task1.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

     private static String PASSWORD;


    public InputValidator(@Value("${app.password}")String password) {
        InputValidator.PASSWORD = password;
    }

    public static boolean isValidPassword(String password) {
        /**
         * Checks if the password is valid.
         */
        System.out.println("Password: " + PASSWORD);
        return password != null && password.equals(PASSWORD);
    }
}
