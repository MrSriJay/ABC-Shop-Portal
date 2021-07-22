package abc.springframework.springwebapp.controllers;

import abc.springframework.springwebapp.domain.Promotion;
import abc.springframework.springwebapp.repositories.PromotionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PromotionControllerTest {

    @Autowired
    private PromotionRepository promotionRepository;

    @Test
    void getPromotions() {

    }

    @Test
    void create() {
    }

    @Test
    void addPromotion() {

        Promotion promotion = new Promotion("Seasonal Special","2021-01-04","2021-01-04",25);
        promotionRepository.save(promotion);
    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void updatePromotion() {
    }

    @Test
    void deletePromotionr() {
    }
}