package abc.springframework.springwebapp.repositories;


import abc.springframework.springwebapp.domain.Promotion;
import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository  extends CrudRepository<Promotion, Long> {
}
