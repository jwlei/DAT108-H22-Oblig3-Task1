package task1.controller.shoppingList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import task1.utility.LoginUtility;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class WebShopController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;
    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;

    /**
     * GET /webshop is the request for retrieving the webshop.
     */
    @GetMapping("${app.url.webshop}")
    public  String getWebshop(HttpSession session, RedirectAttributes ra) {

        if (session.getAttribute("loggedIn") == null) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        return "webshopView";
    }

    @PostMapping
    public String AddToCart(@RequestParam("item") String item,
                            ArrayList<String> items,
                            HttpSession session,
                            RedirectAttributes ra) {



        if (!LoginUtility.isLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);

        return "redirect:" + WEBSHOP_URL;
    }
}
