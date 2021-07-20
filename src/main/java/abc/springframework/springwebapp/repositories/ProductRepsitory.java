package abc.springframework.springwebapp.repositories;

import abc.springframework.springwebapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepsitory  extends CrudRepository<Product, Long> {
}
