package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.domain.Product;
import abc.springframework.springwebapp.domain.Promotion;
import abc.springframework.springwebapp.repositories.ProductRepsitory;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PromotionController {

    private  final PromotionRepository promotionRepository;

    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    //Get all promotions to view
    @RequestMapping("/inventory/promotions")
    public String getPromotions(Model model){
        model.addAttribute("promotions",promotionRepository.findAll());
        return "promotions/list";
    }

    //Add New promotions Form
    @RequestMapping("/inventory/promotions/create")
    public String create(Model model){
        Promotion promotion = new Promotion();
        model.addAttribute("promotion",promotion);
        return "promotions/add";
    }

    //Add New promotions Method
    @RequestMapping(value="/inventory/promotions" , method= RequestMethod.POST)
    public String addPromotion(@ModelAttribute("promotion") Promotion promotion, BindingResult result, Model model, RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            return "redirect:/inventory/promotions/create";
        }
        promotionRepository.save(promotion);
        redirAttrs.addFlashAttribute("success", "Promotion Added Successfully");
        return "redirect:/inventory/promotions";
    }

    //Edit page - Promotion
    @GetMapping("/inventory/promotions/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("promotion",promotion);
        return "promotions/edit";
    }

    //Edit Promotion Method
    @PostMapping("/inventory/promotions/update/{id}")
    public String updatePromotion(@PathVariable("id") long id, @Valid Promotion promotion,
                                BindingResult result, Model model,  RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            promotion.setId(id);
            return "redirect:/inventory/promotions";
        }

        promotionRepository.save(promotion);
        redirAttrs.addFlashAttribute("success", "Promotion Updated Successfully");
        return "redirect:/inventory/promotions";
    }

    //Delete - Promotion
    @GetMapping("/inventory/promotions/delete/{id}")
    public String deletePromotionr(@PathVariable("id") long id, Model model, RedirectAttributes redirAttrs) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        promotionRepository.delete(promotion);
        redirAttrs.addFlashAttribute("success", "Promotion Deleted Successfully");
        return "redirect:/inventory/promotions";
    }




}
