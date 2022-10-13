package task1.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class InputValidator extends PropertyEditorSupport {

     private static String PASSWORD;


    /**
     * Constructor
     * @param password
     */
    public InputValidator(@Value("${app.password}")String password) {
        InputValidator.PASSWORD = password;
    }


    /**
     * Checks if the password matches the password in the application.properties file.
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password) {

        System.out.println("Password: " + PASSWORD);
        return password != null && password.equals(PASSWORD);
    }
}
