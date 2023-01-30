package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.OrderHeader;
import ken.learning.Order.Service.domain.OrderLine;
import ken.learning.Order.Service.domain.Product;
import ken.learning.Order.Service.domain.ProductStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp(){
        Product newProduct  = new Product();
        newProduct.setDescription("Bicycle");
        newProduct.setProductStatus(ProductStatus.NEW);
        product = productRepository.saveAndFlush(newProduct);

    }
    @Test
    void testSaveOrderWithLine(){
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Red Skelton");

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setProduct(product);

        orderHeader.addOrderLine(orderLine);

        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        orderHeaderRepository.flush();

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(savedOrder.getOrderLines().size(), 1);

        OrderHeader fetchedOrder = orderHeaderRepository.getOrderHeaderById(savedOrder.getId());
        assertNotNull(fetchedOrder);
        assertEquals(fetchedOrder.getOrderLines().size(), 1);

    }

    @Test
    void testSaveOrderHeader(){
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Clem Cladiddlehopper");
        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());

        OrderHeader fetchedOrder = orderHeaderRepository.getOrderHeaderById(savedOrder.getId());
        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
        assertNotNull(fetchedOrder.getCreatedDate());
        assertNotNull(fetchedOrder.getLastModifiedDate());

    }

//    @Test
//    void getOrderHeaderById() {
//    }
//
//    @Test
//    void findOrderHeaderByCustomerName() {
//    }
}