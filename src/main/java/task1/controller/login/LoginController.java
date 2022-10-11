package task1.controller.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import task1.model.User;
import task1.utility.InputValidator;
import task1.utility.LoginUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes
public class LoginController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;
    @Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;


    /**
     * GET /login is the request for retrieving the login form.
     */
    @GetMapping("/login")
    public String getLoginForm() {
        return "loginView";
    }

    /**
     * POST /login is the request for logging in.
     */
    @PostMapping(value = "/validate")
    public String validate(@RequestParam(value = "password") String password,
                           HttpSession session,
                           RedirectAttributes ra) {

        User user = new User(session);

        if (!InputValidator.isValidPassword(password)) {
            ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        LoginUtility.logIn(session, password);

        return "redirect:" + WEBSHOP_URL;
    }
}
