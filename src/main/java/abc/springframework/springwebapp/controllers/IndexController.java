package abc.springframework.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getHome(Model model){
        return "main/index";
    }

    @RequestMapping("/customer")
    public String getProducts(Model model){
        return "main/customer";
    }

    @RequestMapping("/inventory")
    public String getInventory(Model model){
        return "main/inventory";
    }

}
