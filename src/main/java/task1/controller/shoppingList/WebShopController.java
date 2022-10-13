package task1.controller.shoppingList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import task1.model.Cart;
import task1.model.Item;
import task1.utility.LoginUtility;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        /**
         * If the user is not logged in, redirect to the login page.
         * Otherwise, show the webshop.
         */

        if (session.getAttribute("loggedIn") == null) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        session.getAttribute("cart");
        return "webshopView";
    }

    @PostMapping("/addItem")
    public String AddToCart(@RequestParam("item") String item,
                            List<Item> items,
                            HttpSession session,
                            RedirectAttributes ra) {
        /**
         * If the user is not logged in, redirect to the login page.
         * Otherwise, add the item to the shopping cart.
         */
        if (!LoginUtility.isLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        Cart cart = (Cart) session.getAttribute("cart");

        items.add(new Item(item));

        return "redirect:" + WEBSHOP_URL;
    }
}
