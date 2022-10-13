package task1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.util.HtmlUtils;
import task1.model.Cart;
import task1.model.Item;
import task1.utility.SessionUtility;


@Controller
public class WebShopController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;
    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
    @Value("${app.message.itemExists}") private String ITEM_EXISTS_MESSAGE;
    @Value("${app.message.itemNoExists}") private String ITEM_NO_EXISTS_MESSAGE;
    @Value("${app.message.itemNameSize}") private String ITEM_NAME_SIZE_MESSAGE;
    //@Value("${app.message.itemEmpty}") private String ITEM_EMPTY_MESSAGE;


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
     * Validate the item, if valid redirect it to the addItem controller
     * @param item
     * @param bindingResult
     * @param ra
     * @return viewStringURL
     */
    @PostMapping("/addItem")
    public String validateItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult, RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            //ra.addFlashAttribute("redirectMessage", ITEM_NAME_SIZE_MESSAGE);
            return "redirect:" + WEBSHOP_URL;
        }
        ra.addFlashAttribute("item", item);

        return "redirect:addItem-success";
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
    @GetMapping("/addItem-success")
    public String addItem(@ModelAttribute("item") Item item,
                          HttpSession session,
                          RedirectAttributes ra) {

        // Check if the session is valid
        if (!SessionUtility.isLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        // Get the cart from the session
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart.itemExists(item)) {
            ra.addFlashAttribute("redirectMessage", ITEM_EXISTS_MESSAGE);
            return "redirect:" + WEBSHOP_URL;
        } else {
            // Escape HTML characters when using the item name from the form
            cart.addItem(new Item(HtmlUtils.htmlEscape(item.getName())));
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

        if (!cart.itemExists(item)) {
            ra.addFlashAttribute("redirectMessage", ITEM_NO_EXISTS_MESSAGE);
            return "redirect:" + WEBSHOP_URL;
        }

        cart.removeItem(item);

        return "redirect:" + WEBSHOP_URL;
    }
}
