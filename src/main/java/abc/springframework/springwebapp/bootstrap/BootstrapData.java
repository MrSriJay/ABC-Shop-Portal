package abc.springframework.springwebapp.bootstrap;

import abc.springframework.springwebapp.domain.Product;
import abc.springframework.springwebapp.domain.Promotion;
import abc.springframework.springwebapp.repositories.ProductRepsitory;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    // Implementing Components
    private final ProductRepsitory productRepsitory;
    private final PromotionRepository promotionRepository;

    public BootstrapData(ProductRepsitory productRepsitory, PromotionRepository promotionRepository) {
        this.productRepsitory = productRepsitory;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Doing Dependancy Injection
        Product shampoo = new Product("Hair Shampoo",500.00,"2022-01-04",10);
        Promotion shampooPromotion = new Promotion("New Year Promo","2021-01-04",200.00);

        shampooPromotion.getProducts().add(shampoo);

        productRepsitory.save(shampoo);


        Product milk = new Product("Anchor Milk Packet",180.00,"2022-01-04",0);
        Promotion milkPromo = new Promotion("Christmas Special","2021-01-04",25);

        milkPromo.getProducts().add(milk);

        productRepsitory.save(milk);
        promotionRepository.save(milkPromo);

        Product biscuit = new Product("Bisucit Packet",60.00,"2022-01-04",0);
        shampooPromotion.getProducts().add(biscuit);

        productRepsitory.save(biscuit);
        promotionRepository.save(shampooPromotion);


        Product Noodles = new Product("Prima Noodles Packet",80.00,"2022-01-04",5);
        productRepsitory.save(Noodles);


        System.out.println("Program started");
        System.out.println("Number of promotions "+promotionRepository.count());

    }

}
