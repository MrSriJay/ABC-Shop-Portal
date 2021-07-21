package abc.springframework.springwebapp.repositories;

import abc.springframework.springwebapp.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface  CustomerRepository extends CrudRepository<Product, Long> {

    @Query(
            value = "SELECT  EXPIRE_DATE, PRICE,TAX, PROMO_NAME, PROMO_AMOUNT, PRODUCT_NAME, START_DATE, END_DATE FROM PRODUCT  OUTER JOIN PROMOTION",
            nativeQuery = true)
    Collection<Product> findAllActiveUsersNative();
}
