package task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public RedirectView home() {
        /*
         * Redirect to the index page
         */
        return new RedirectView("index.html");
    }
}
