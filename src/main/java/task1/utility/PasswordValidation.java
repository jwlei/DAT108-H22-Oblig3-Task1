package task1.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class PasswordValidation extends PropertyEditorSupport {

     private static String PASSWORD;


    /**
     * Constructor
     * @param password
     */
    public PasswordValidation(@Value("${app.password}")String password) {
        PasswordValidation.PASSWORD = password;
    }


    /**
     * Checks if the password matches the password in the supplied from
     * the application.properties file.
     * @param password
     * @return boolean
     */
    public static boolean isValidPassword(String password) {

        return password != null && password.equals(PASSWORD);
    }
}
