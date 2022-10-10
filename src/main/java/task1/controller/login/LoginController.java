package task1.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value="/login", produces="text/plain")
    public String login() {
        return "login";
    }

}
