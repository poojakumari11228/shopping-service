package webshop.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.shopping.domain.ShoppingCart;

import java.util.Optional;

@Repository
public interface ShoppingCartRepo extends MongoRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByShoppingCartNumber(Long id);
}
