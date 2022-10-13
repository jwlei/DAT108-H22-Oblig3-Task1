package task1.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class InputUtility extends PropertyEditorSupport {

     private static String PASSWORD;


    /**
     * Constructor
     * @param password
     */
    public InputUtility(@Value("${app.password}")String password) {
        InputUtility.PASSWORD = password;
    }


    /**
     * Checks if the password matches the password in the application.properties file.
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password) {

        return password != null && password.equals(PASSWORD);
    }
}
