package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.repositories.ProductRepsitory;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    private  final ProductRepsitory productRepsitory;
    private  final PromotionRepository promotionRepository;

    public CustomerController(ProductRepsitory productRepsitory, PromotionRepository promotionRepository) {
        this.productRepsitory = productRepsitory;
        this.promotionRepository = promotionRepository;
    }

    //Get all products to view
    @RequestMapping("/customer/products")
    public String getProducts(Model model){
        model.addAttribute("products",productRepsitory.findAll());
        return "customer/list";
    }

}
