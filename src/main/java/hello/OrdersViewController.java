package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersViewController {

    @RequestMapping("/orders")
    public String greeting(String name, Model model) {
        model.addAttribute("name", name);
        return "orders";
    }

}