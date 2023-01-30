package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;


    @Test
    void testGetCategory(){
        Product product = productRepository.findByDescription("Bicycle 1");
        assertNotNull(product);
        assertNotNull(product.getCategories());
    }

    @Test
    void testSaveOrderHeader(){
        Product product = new Product();
        product.setDescription("Vacuum");
        Product savedProduct = productRepository.save(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());

        Product fetchedOrder = productRepository.getProductsById(savedProduct.getId());
        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
        assertNotNull(fetchedOrder.getCreatedDate());
        assertNotNull(fetchedOrder.getLastModifiedDate());

    }

}