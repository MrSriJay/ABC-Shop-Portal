package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.repositories.ProductRepsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private  final ProductRepsitory productRepsitory;

    public ProductController(ProductRepsitory productRepsitory) {
        this.productRepsitory = productRepsitory;
    }

    @RequestMapping("/products")
    public String getproducts(Model model){

        model.addAttribute("products",productRepsitory.findAll());
        return "products";
    }

}
