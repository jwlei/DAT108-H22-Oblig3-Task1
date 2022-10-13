package task1.controller.sessionController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {



    @GetMapping("checkSession")
    public String checkSession(HttpSession session, RedirectAttributes ra) {



        return "temp";
    }
}
