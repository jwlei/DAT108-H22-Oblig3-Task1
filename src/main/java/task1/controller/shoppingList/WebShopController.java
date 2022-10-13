package task1.controller.shoppingList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import task1.model.Cart;
import task1.model.Item;
import task1.utility.SessionUtility;


@Controller
public class WebShopController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;
    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
    @Value("${app.message.itemEmpty}") private String ITEM_EMPTY_MESSAGE;
    @Value("${app.message.itemExists}") private String ITEM_EXISTS_MESSAGE;


    /**
     * GET /webshop is the request for retrieving the webshop.
     * If the user is not logged in, redirect to the login page.
     * Otherwise, show the webshop.
     *
     * @param session
     * @param ra
     * @return viewStringURL
     */
    @GetMapping("${app.url.webshop}")
    public  String getWebshop(HttpSession session, RedirectAttributes ra) {

        if (session.getAttribute("loggedIn") == null) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        session.getAttribute("cart");

        return "webshopView";
    }


    /**
     * POST /addItem is the request for adding an item to the cart.
     * If the user is not logged in, redirect to the login page.
     * Otherwise, add the item to the cart and redirect to the webshop.
     * @param item
     * @param session
     * @param ra
     * @return viewStringURL
     */
    @PostMapping("/addItem")
    public String addItem(@RequestParam("item") String item,
                          HttpSession session,
                          RedirectAttributes ra) {

        // Check if the session is valid
        if (!SessionUtility.isLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        // Get the cart from the session
        Cart cart = (Cart) session.getAttribute("cart");

        // Check if the item can be added to the cart
        if (item == null || item.isEmpty()) {
            ra.addFlashAttribute("redirectMessage", ITEM_EMPTY_MESSAGE);
            return "redirect:" + WEBSHOP_URL;

        } else if (cart.itemExists(item)) {
            ra.addFlashAttribute("redirectMessage", ITEM_EXISTS_MESSAGE);
            return "redirect:" + WEBSHOP_URL;

        } else {
            cart.addItem(new Item(item));
        }

        return "redirect:" + WEBSHOP_URL;
    }


    /**
     * POST /removeItem is the request for removing an item from the cart.
     * If the user is not logged in, redirect to the login page.
     * Otherwise, remove the item from the cart and redirect to the webshop.
     * @param item
     * @param session
     * @param ra
     * @return viewStringURL
     */
    @PostMapping("/removeItem")
    public String removeItem(@ModelAttribute("itemForDeletion") Item item,
                            HttpSession session,
                            RedirectAttributes ra) {

        // Check if the session is valid
        if (!SessionUtility.isLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        // Get the cart from the session
        Cart cart = (Cart) session.getAttribute("cart");

        cart.removeItem(item);

        return "redirect:" + WEBSHOP_URL;
    }
}
