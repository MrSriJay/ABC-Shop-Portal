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
        promotionRepository.save(shampooPromotion);

        System.out.println("Program started");
        System.out.println("Number of promotions "+promotionRepository.count());

    }

}
