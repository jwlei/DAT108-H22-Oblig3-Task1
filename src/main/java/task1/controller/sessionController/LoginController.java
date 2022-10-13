package task1.controller.sessionController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import task1.utility.InputValidator;
import task1.utility.SessionUtility;


@Controller
@SessionAttributes
public class LoginController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;
    @Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;

    /**
     * GET /login is the request for retrieving the login page.
     * If the user is already logged in, redirect to the webshop.
     * Otherwise, show the login form.
     * @param session
     * @return viewStringURL
     */
    @GetMapping("/login")
    public String getLoginForm(HttpSession session) {

        if (session.getAttribute("loggedIn") != null) {
            return "redirect:" + WEBSHOP_URL;
        }
        return "loginView";
    }


    /**
     * If the password is correct, log in the user and redirect to the webshop.
     * Otherwise, show the login form again with an INVALID_PASSWORD_MESSAGE.
     * @param password
     * @param session
     * @param ra
     * @return viewStringURL
     */
    @PostMapping(value = "/validate")
    public String validate(@RequestParam(value = "password") String password,
                           HttpSession session,
                           RedirectAttributes ra) {

        if (!InputValidator.isValidPassword(password)) {
            ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        SessionUtility.logIn(session);

        return "redirect:" + WEBSHOP_URL;
    }
}
