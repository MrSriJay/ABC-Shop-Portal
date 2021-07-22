package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.domain.Product;
import abc.springframework.springwebapp.domain.Promotion;
import abc.springframework.springwebapp.repositories.ProductRepsitory;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductControllerTest {

    @Autowired
    private ProductRepsitory productRepsitory;

    @Test
    void getProducts() {


    }

    @Test
    void create() {
    }

    @Test
    void createProduct() {

        Product product = new Product("Snak Milk",180.00,"2022-01-04",0);
        productRepsitory.save(product);

    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}