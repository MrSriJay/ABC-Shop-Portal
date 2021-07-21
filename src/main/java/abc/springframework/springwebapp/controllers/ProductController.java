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
public class ProductController {

    private  final ProductRepsitory productRepsitory;
    private  final PromotionRepository promotionRepository;



    public ProductController(ProductRepsitory productRepsitory, PromotionRepository promotionRepository) {
        this.productRepsitory = productRepsitory;
        this.promotionRepository = promotionRepository;
    }



    //Get all products to view
    @RequestMapping("/inventory/products")
    public String getProducts(Model model){
        model.addAttribute("products",productRepsitory.findAll());
        return "products/list";
    }

    //Add New Products Form
    @RequestMapping("/inventory/products/create")
    public String create(Model model){
        Product product = new Product();

        model.addAttribute("product",product);
        model.addAttribute("promotions",promotionRepository.findAll());
        return "products/add";
    }


    //Add New Product Method
    @RequestMapping(value="/inventory/products" , method= RequestMethod.POST)
    public String  createProduct( @Valid @ModelAttribute("product") Product product,  BindingResult result, Model model, RedirectAttributes redirAttrs) {

        if (result.hasErrors()) {
            return "redirect:/inventory/products/create";
        }
        productRepsitory.save(product);
        redirAttrs.addFlashAttribute("success", "Product Added Successfully");
        return "redirect:/inventory/products";
    }

    //Edit page - Product
    @GetMapping("/inventory/products/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepsitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("product",product);
        return "products/edit";
    }

    //Edit Product Method
    @PostMapping("/inventory/products/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid Product product,
                             BindingResult result, Model model,  RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            product.setId(id);
            return "redirect:/inventory/products";
        }

        productRepsitory.save(product);
        redirAttrs.addFlashAttribute("success", "Product Updated Successfully");
        return "redirect:/inventory/products";
    }


    //Delete - Product
    @GetMapping("/inventory/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model, RedirectAttributes redirAttrs) {
        Product product = productRepsitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepsitory.delete(product);
        redirAttrs.addFlashAttribute("success", "Product Deleted Successfully");
        return "redirect:/inventory/products";
    }



}
