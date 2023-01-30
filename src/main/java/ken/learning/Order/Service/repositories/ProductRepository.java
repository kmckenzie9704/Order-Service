package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductsById(Long Id);
    Product findByDescription(String description);

}
