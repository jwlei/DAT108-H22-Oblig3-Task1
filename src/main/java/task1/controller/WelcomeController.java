package task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WelcomeController {

    /**
     * Listens for localhost:8080/ and redirects to the landing page
     * @return RedirectView
     */
    @RequestMapping(value = "/")
    public RedirectView home() {
        return new RedirectView("index.html");
    }
}
