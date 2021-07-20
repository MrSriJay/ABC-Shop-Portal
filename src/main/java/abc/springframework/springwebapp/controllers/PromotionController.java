package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.repositories.ProductRepsitory;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PromotionController {

    private  final PromotionRepository promotionRepository;

    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    //Get all promotions to view
    @RequestMapping("/promotions")
    public String getPromotions(Model model){
        model.addAttribute("promotions",promotionRepository.findAll());
        return "promotions/list";
    }

}
